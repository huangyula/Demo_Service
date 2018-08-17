// AIDL_Service1.aidl
package com.hy.demo_service;

// Declare any non-default types here with import statements

interface AIDL_Service1 {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);

            void AIDL_Service();

            void add(int a,int b);

}
