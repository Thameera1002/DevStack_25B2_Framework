package com.devstack.b2.automation.util;

import java.lang.reflect.Method;

public class ExcelHandler {

    private static final String EXCEL_PATH= "src/test/resources/excelData";

    public static Object[][] commonDataProvider(Method method){
        String testClassName = method.getDeclaringClass().getSimpleName();
        String testMethodName = method.getName();
        String excelFileName = testClassName+".xlsx";

        Class<?> modelClass = getModelClass(testClassName);

        return readExcelData(EXCEL_PATH+excelFileName,testMethodName,modelClass);
    }

    private static Class<?> getModelClass(String testClassName) {
        String modelClassName = testClassName+"Model";
        try {
            return Class.forName("com.devstack.b2.automation.model"+modelClassName);
        }catch (ClassNotFoundException e){
            throw new RuntimeException("Could not find model class "+modelClassName,e);
        }
    }
}
