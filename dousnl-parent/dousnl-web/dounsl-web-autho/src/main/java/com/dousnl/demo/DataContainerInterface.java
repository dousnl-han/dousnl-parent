package com.dousnl.demo;

public interface DataContainerInterface {

     String str="NSSF";

     default DataContainer getDataContainer() {
          return new DataContainer(str);
     }

}
