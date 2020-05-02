package com.tsimul.configuration;

/**
 * Idea: Read a config file (json) and generate an iot system
 * The config file contains the sensors to be generated and their specifications
 * Specification contains:
 * - id: the sensor id, can be null (if so, an id should be generated while creating the sensor)
 * - name: The sensor name, cannot be null
 * - type:
 *  - Numerical:
 *      - min: the minimum value of the sensor
 *      - max: the maximum value of the sensor
 *  - boolean (?) Not yet implemented
 *  - custom (?) Not yet implemented
 * - frequency: the frequency of generation in seconds
 * - unity: the unity of measurement
 * - channel: enumOf [http, ws, sse] the technology to use to send the data on the network
 */
public class Config {

    public void load(String filePath){}
    public void load(){}

}
