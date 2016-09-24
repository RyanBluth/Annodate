package com.annodate;

import com.annodate.annotations.Validators;
import com.annodate.validators.ValidationResult;
import com.annodate.validators.Validator;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Annodate {

    private static HashMap<Class<? extends Annotation>, List<Validator>> cache = new HashMap<>();

    @SuppressWarnings({"unchecked"})
    public static List<AnnodateError> validate(Object instance){
        List<AnnodateError> errors = new ArrayList<>();
        Field[] fields = instance.getClass().getDeclaredFields();
        for (Field field : fields) {
            AnnodateError fieldErrors = new AnnodateError( field.getName() );
            List<Validator> validators;
            Annotation[] fieldAnnotations = field.getDeclaredAnnotations();
            for (Annotation fieldAnnotation : fieldAnnotations) {
                Class<? extends Annotation> fieldAnnotationType = fieldAnnotation.annotationType();
                if ( !cache.containsKey(fieldAnnotationType)) {
                    for (Annotation annotationAnnotation : fieldAnnotationType.getDeclaredAnnotations()) {
                        Class<? extends Annotation> annType = annotationAnnotation.annotationType();
                        if (annotationAnnotation.annotationType().equals(Validators.class)) {
                            Class<? extends Validator>[] annValidators;
                            try {
                                annValidators = (Class<? extends Validator>[]) annType
                                        .getDeclaredMethod("value").invoke(annotationAnnotation);

                                List<Validator> valInstances = new ArrayList<>();
                                for( Class<? extends Validator> valClass : annValidators ){
                                    valInstances.add( valClass.newInstance() );
                                }
                                cache.put(fieldAnnotationType, valInstances);
                            } catch (Exception ex) {
                                throw new RuntimeException(ex);
                            }
                        }
                    }
                }
                validators = cache.get(fieldAnnotationType);
                if(validators != null) {
                    for (Validator validator : validators) {
                        field.setAccessible(true);
                        ValidationResult res;
                        try {
                            res = validator.validate(field.get(instance), fieldAnnotation);
                        } catch (IllegalAccessException e) {
                            throw new RuntimeException(e);
                        }
                        if (!res.isValid()) {
                            fieldErrors.addError(res.getReason());
                            if(!errors.contains(fieldErrors)){
                                errors.add(fieldErrors);
                            }
                        }
                    }
                }
            }
        }
        return errors;
    }

}
