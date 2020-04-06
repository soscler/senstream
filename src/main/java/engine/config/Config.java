package engine.config;

/**
 * Idea: Read a config file (json) and generate a system
 * The config file contains the sensors to be generated and their specifications
 * Specification contains:
 * - id: the sensor id, can be null (if so, an id should be generated while creating the sensor)
 * - name: The sensor name, cannot be null
 * - type:
 *  - Numerical:
 *      - min: the minimum value of the sensor
 *      - max: the maximum value of the sensor
 * - frequency: the frequency of generation in seconds
 * - unity: the unity of measurement
 *
 */
public class Config {

}
