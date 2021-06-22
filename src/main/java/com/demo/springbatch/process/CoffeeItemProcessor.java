package com.demo.springbatch.process;

import com.demo.springbatch.model.Coffee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.data.builder.MongoItemReaderBuilder;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.batch.runtime.BatchStatus;
import javax.batch.runtime.JobExecution;

public class CoffeeItemProcessor implements ItemProcessor<Coffee, Coffee> {

    private static final Logger LOGGER = LoggerFactory.getLogger(CoffeeItemProcessor.class);

    @Override
    public Coffee process(Coffee coffee) throws Exception {
        String brand = coffee.getBrand().toUpperCase();
        String origin = coffee.getOrigin().toUpperCase();
        String chracteristics = coffee.getCharacteristics().toUpperCase();

        Coffee transformedCoffee = new Coffee(brand, origin, chracteristics);
        LOGGER.info("Converting ( " + coffee + " ) into ( " + transformedCoffee + " )");

        return transformedCoffee;
    }


}
