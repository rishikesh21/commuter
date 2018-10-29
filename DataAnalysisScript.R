library(data.table)
library(lubridate)
library(dplyr)
setwd("~/IntelIjPrograms/commuter/")

data=fread("~/Downloads/origin_destination_train_201809.csv")
data_03=fread("~/Downloads/origin_destination_train_201808.csv")
data_09=fread("~/Downloads/origin_destination_train_201807.csv")

odp=data[,list(SUM_TOTAL_TRIPS=sum(TOTAL_TRIPS)),by=list(ORIGIN_PT_CODE,DESTINATION_PT_CODE)][order(-rank(SUM_TOTAL_TRIPS))]
odp_by_hour=data[,list(SUM_TOTAL_TRIPS=sum(TOTAL_TRIPS)),by=list(TIME_PER_HOUR,ORIGIN_PT_CODE,DESTINATION_PT_CODE)][order(-rank(SUM_TOTAL_TRIPS))]