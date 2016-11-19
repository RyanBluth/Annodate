package com.annodate;

import com.annodate.annotations.OneOf;
import com.annodate.annotations.Validators;
import com.annodate.validators.OneOfValidator;
import com.annodate.validators.ValidationResult;
import com.annodate.validators.Validator;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.*;

public class Annodate {

    private static HashMap<Class<? extends Annotation>, List<Validator>> cache = new HashMap<>();

    private static AnnodateValidatorProvider defaultValidatorProvider = new AnnodateValidatorProvider() {

        @Override
        public Map<Class<? extends Annotation>, List<Class<? extends Validator>>> wireValidators() {
            Map<Class<? extends Annotation>, List<Class<? extends Validator>>> wiring = new HashMap<>();
            return wiring;
        }
    };

    private static AnnodateErrorProvider defaultErrorProvider = new AnnodateErrorProvider() {
        @Override
        public AnnodateError buildError(Validator validator, ValidationResult validationResult) {
            return null;
        }
    };

    @SuppressWarnings({"unchecked"})
    public static List<AnnodateError> validate(Object instance) {
        return validate(instance, defaultValidatorProvider);
    }

    @SuppressWarnings({"unchecked"})
    public static List<AnnodateError> validate(Object instance, AnnodateValidatorProvider... providers) {
        List<AnnodateValidatorProvider> lProviderList = new ArrayList<>( providers.length + 1 );
        lProviderList.add( 0, defaultValidatorProvider);
        List<AnnodateError> errors = new ArrayList<>();
        Field[] fields = instance.getClass().getDeclaredFields();
        for (Field field : fields) {
            AnnodateError fieldErrors = new AnnodateError( field.getName() );
            List<Validator> validators;
            Annotation[] fieldAnnotations = field.getDeclaredAnnotations();
            HashMap<Class<? extends Annotation>, List<Validator>> allValidators = new HashMap<>();
            allValidators.putAll( collectValidators(lProviderList) );
            for (Annotation fieldAnnotation : fieldAnnotations) {
                Class<? extends Annotation> fieldAnnotationType = fieldAnnotation.annotationType();
                if ( !cache.containsKey(fieldAnnotationType)) {
                    boolean hasValidatorAnnotation = false;
                    for (Annotation annotationAnnotation : fieldAnnotationType.getDeclaredAnnotations()) {
                        Class<? extends Annotation> annType = annotationAnnotation.annotationType();
                        if (annotationAnnotation.annotationType().equals(Validators.class)) {
                            hasValidatorAnnotation = true;
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
                    if( !hasValidatorAnnotation ){
                        if(allValidators.containsKey( fieldAnnotationType )){
                            cache.put( fieldAnnotationType, allValidators.get( fieldAnnotationType ) );
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

    private static HashMap<Class<? extends Annotation>, List<Validator>> collectValidators( List<AnnodateValidatorProvider> providers ){
        HashMap<Class<? extends Annotation>, List<Validator>> ret = new HashMap<>();
        try {
            for (AnnodateValidatorProvider prov : providers) {
                Map<Class<? extends Annotation>, List<Class<? extends Validator>>> classListMap = prov.wireValidators();
                for (Class<? extends Annotation> annClassIter : classListMap.keySet()) {
                    List<Validator> lInstances = new ArrayList<>();
                    for (Class<? extends Validator> valClazz : classListMap.get(annClassIter)) {
                        lInstances.add( valClazz.newInstance() );
                    }
                    ret.put( annClassIter, lInstances);
                }
            }
        }catch (Exception ex){
            throw new RuntimeException();
        }
        return ret;
    }

}
