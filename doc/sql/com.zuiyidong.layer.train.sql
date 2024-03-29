use crawler;
create table layer_com_zuiyidong_layer_train (
        id                 bigint auto_increment,        
        name               varchar(100),
        trainNum           varchar(30), 
        origin             varchar(30),
        dest               varchar(30),
        leaveAt            varchar(15),
        arriveAt           varchar(15),
        type               varchar(10),
        totalMile          varchar(10),
        totalTime          varchar(10),
        zuo                varchar(20),
        yingwo             varchar(20),
        ruanwo             varchar(20),
        deng               varchar(20), 
        createTime         datetime,
        updateTime         datetime,
        PRIMARY KEY (id)
); 
        
create table layer_com_zuiyidong_layer_trainstation (
        id                 bigint auto_increment,
        trainId            bigint,        
        seq                int,        
        name               varchar(20),
        lng                double,
        lat                double,
        province           varchar(20),
        city               varchar(20),
        district           varchar(20),
        lat1               double,
        lat2               double,
        lng1               double,
        lng2               double,
        arriveAt           varchar(15),
        leaveAt            varchar(15),
        totalTime          varchar(10),
        totalMile          varchar(10),
        zuo                varchar(20),
        yingwo             varchar(20),
        ruanwo             varchar(20),
        deng               varchar(20), 
        createTime         datetime,
        updateTime         datetime,         
        PRIMARY KEY (id)
);


create index train_trainNum  on layer_com_zuiyidong_layer_train(trainNum); 
create index train_station_name  on layer_com_zuiyidong_layer_trainstation(name);
create index train_station_lng  on layer_com_zuiyidong_layer_trainstation(lng);
create index train_station_lat  on layer_com_zuiyidong_layer_trainstation(lat);
create index train_station_trainId  on layer_com_zuiyidong_layer_trainstation(trainId);
 
ALTER TABLE layer_com_zuiyidong_layer_train AUTO_INCREMENT = 100000000000000;
ALTER TABLE layer_com_zuiyidong_layer_trainstation AUTO_INCREMENT = 100000000000000;

create view layer_com_zuiyidong_layer_trainstation_v as select 
        t.name as trainName, t.trainNum as trainNum, t.origin as trainOrigin, t.dest as trainDest,
        t.leaveAt as trainLeaveAt, t.arriveAt as trainArriveAt, t.type as trainType, t.totalMile as trainTotalMile,
        t.totalTime as trainTotalTime,         
        ts.* 
        from layer_com_zuiyidong_layer_trainstation ts, layer_com_zuiyidong_layer_train t 
        where ts.trainId = t.id;


/**
these should be run after gps data is crawled from google

update layer_com_zuiyidong_layer_trainstation set lng=110.206263, lat=31.64636, province='湖北', city='白河' where name ='白河东';
update layer_com_zuiyidong_layer_trainstation set lng=115.021727, lat=27.105207, province='江西省', city='吉安市', district='青原区' where name ='吉安';
update layer_com_zuiyidong_layer_trainstation set lng=99.065609, lat=39.350361, province='甘肃省', city=null, district=null where name ='清水';

*/        

create table Object_TrainTicket(
        id                 bigint auto_increment,
        trainNum           varchar(30),
        type               varchar(10), 
        origin             varchar(30),        
        dest               varchar(30),
        contact            varchar(10),
        tel                varchar(15),
        ticketCount        varchar(3),
        ticketDate         date,
        price              varchar(5),
        note               varchar(500),
        place              varchar(20),
        createTime         datetime,         
        PRIMARY KEY (id)
);

create index ticket_trainNum  on Object_TrainTicket(trainNum); 
create index ticket_origin  on Object_TrainTicket(origin); 
create index ticket_dest  on Object_TrainTicket(dest); 
create index ticket_ticketDate  on Object_TrainTicket(ticketDate); 
create index ticket_createTime  on Object_TrainTicket(createTime); 



create table layer_com_zuiyidong_layer_train_ticketoffice(
        id                 int auto_increment,
        lng                double,
        lat                double,     
        province           varchar(20),
        city               varchar(20),
        district           varchar(20),           
        name               varchar(100),        
        tel                varchar(100),
        address            varchar(200),
        createTime         datetime,         
        PRIMARY KEY (id)
);


ALTER TABLE layer_com_zuiyidong_layer_train_ticketoffice AUTO_INCREMENT = 100000;



