module example.ebean-querybean-assoc {

    requires io.ebean.h2;

    opens dbmigration;
    exports org.example;
    opens org.example;

    provides io.ebean.config.ModuleInfoLoader with org.example._Ebean$ModuleInfo;

}