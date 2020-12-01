-- Reference from https://medium.com/@Sushil_Kumar/binary-logistic-regression-with-bigquery-ml-c9caa5920a71, and https://cloud.google.com/bigquery-ml/docs/logistic-regression-prediction

SELECT
    *
FROM
    ML.PREDICT(MODEL `leafy-environs-257822.PIR_TrainingSet2.model_Room1`,
    (
    SELECT
        * EXCEPT(ROW_SPLIT_ID,_Room_2)
    FROM (
        SELECT
            ABS(MOD(FARM_FINGERPRINT(CONCAT( CAST(Month AS STRING), CAST(_Day AS STRING), CAST(_Time_AS STRING), CAST(_Room_1_ AS STRING))),4)) AS ROW_SPLIT_ID,
            *
        FROM
            `leafy-environs-257822.PIR_TrainingSet2.TrainingData` )
        WHERE
            ROW_SPLIT_ID = 3))