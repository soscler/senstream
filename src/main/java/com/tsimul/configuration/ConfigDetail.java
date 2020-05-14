package com.tsimul.configuration;

import com.tsimul.device.DeviceMetadata;
import com.tsimul.util.Metadata;

import java.util.Collections;
import java.util.List;

/**
 * This class is an attempt to reproduce the config json schema as a java class
 * Its purpose it to facilitate the deserialization of json schema to a java object
 * TODO: Should we use nested static class ?
 */
public class ConfigDetail {

    // private Metadata metadata; TODO: Use metadata
    private String name;
    private String senMLVersion;
    private List<DeviceDetail> sensors = Collections.emptyList();
    private List<DeviceDetail> actuators = Collections.emptyList();


    public static class DeviceDetail {

        private DeviceMetadata metadata;
        private Generation generation;
        private TransportType transport = TransportType.HTTP;
        private StorageType storage = StorageType.MONGODB;
        private AnalyticsType analytics = AnalyticsType.BASIC;

        public DeviceDetail() {
        }

        public DeviceDetail(DeviceMetadata metadata, Generation generation) {
            this.metadata = metadata;
            this.generation = generation;
        }

        public static class Generation {

            private GenerationType type;
            private double frequency;
            private double min;
            private double max;

            public Generation() {
            }

            public Generation(GenerationType type, double frequency) {
                this.type = type;
                this.frequency = frequency;
            }

            public Generation(GenerationType type, double frequency, double min, double max) {
                this.type = type;
                this.frequency = frequency;
                this.min = min;
                this.max = max;
            }

            public GenerationType getType() {
                return type;
            }

            public void setType(GenerationType type) {
                this.type = type;
            }

            public double getFrequency() {
                return frequency;
            }

            public void setFrequency(double frequency) {
                this.frequency = frequency;
            }

            public double getMin() {
                return min;
            }

            public void setMin(double min) {
                this.min = min;
            }

            public double getMax() {
                return max;
            }

            public void setMax(double max) {
                this.max = max;
            }
        }

        public DeviceMetadata getMetadata() {
            return metadata;
        }

        public void setMetadata(DeviceMetadata metadata) {
            this.metadata = metadata;
        }

        public Generation getGeneration() {
            return generation;
        }

        public void setGeneration(Generation generation) {
            this.generation = generation;
        }

        public TransportType getTransport() {
            return transport;
        }

        public void setTransport(TransportType transportType) {
            this.transport = transportType;
        }

        public StorageType getStorage() {
            return storage;
        }

        public void setStorage(StorageType storage) {
            this.storage = storage;
        }

        public AnalyticsType getAnalytics() {
            return analytics;
        }

        public void setAnalytics(AnalyticsType analytics) {
            this.analytics = analytics;
        }
    }

    public enum GenerationType {
        NUMERICAL, BOOLEAN
    }

    public enum TransportType {
        HTTP, WS, KAFKA
    }

    public enum StorageType {
        CASSANDRA, MONGODB
    }

    public enum AnalyticsType {
        BASIC, ADVANCED, EXPERT
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSenMLVersion() {
        return senMLVersion;
    }

    public void setSenMLVersion(String senMLVersion) {
        this.senMLVersion = senMLVersion;
    }

    public List<DeviceDetail> getSensors() {
        return sensors;
    }

    public void setSensors(List<DeviceDetail> sensors) {
        this.sensors = sensors;
    }

    public List<DeviceDetail> getActuators() {
        return actuators;
    }

    public void setActuators(List<DeviceDetail> actuators) {
        this.actuators = actuators;
    }
}
