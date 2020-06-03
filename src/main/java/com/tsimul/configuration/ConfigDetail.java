package com.tsimul.configuration;

import com.tsimul.device.DeviceMetadata;
import com.tsimul.event.Event;
import com.tsimul.plugin.PluginMetadata;

import java.util.Collections;
import java.util.List;

/**
 * This class is an attempt to reproduce the config json schema as a java class
 * Its purpose it to facilitate the deserialization of json schema to a java object
 * TODO: Should we use nested static class ?
 * see schema.json
 */

public class ConfigDetail {

    // private Metadata metadata; TODO: Use metadata
    private String name;
    private String description;
    private String senMLVersion;
    private List<DeviceDetail> sensors = Collections.emptyList();
    private List<DeviceDetail> actuators = Collections.emptyList();
    private List<PluginDetail> plugins = Collections.emptyList();

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


    public static class PluginDetail {

        private PluginType type;
        private PluginSubscriptionDetail subscribe;

        public PluginType getType() {
            return type;
        }

        public void setType(PluginType type) {
            this.type = type;
        }

        public PluginSubscriptionDetail getSubscribe() {
            return subscribe;
        }

        public void setSubscribe(PluginSubscriptionDetail subscribe) {
            this.subscribe = subscribe;
        }


        public static class PluginSubscriptionDetail {

            private AllEvent allEvents;
            private SensorEvent sensorsEvents;
            private ActuatorEvent actuatorsEvents;

            public AllEvent getAllEvents() {
                return allEvents;
            }

            public void setAllEvents(AllEvent allEvents) {
                this.allEvents = allEvents;
            }

            public SensorEvent getSensorsEvents() {
                return sensorsEvents;
            }

            public void setSensorsEvents(SensorEvent sensorsEvents) {
                this.sensorsEvents = sensorsEvents;
            }

            public ActuatorEvent getActuatorsEvents() {
                return actuatorsEvents;
            }

            public void setActuatorsEvents(ActuatorEvent actuatorsEvents) {
                this.actuatorsEvents = actuatorsEvents;
            }
        }

        public static class AllEvent {

            private List<Event.EventType> eventTypes;

            public List<Event.EventType> getEventTypes() {
                return eventTypes;
            }

            public void setEventTypes(List<Event.EventType> eventTypes) {
                this.eventTypes = eventTypes;
            }
        }

        public static class SensorEvent {

            private List<GenerationType> sensorsTypes;
            private List<Event.EventType> eventTypes;

            public List<GenerationType> getSensorsTypes() {
                return sensorsTypes;
            }

            public void setSensorsTypes(List<GenerationType> sensorsTypes) {
                this.sensorsTypes = sensorsTypes;
            }

            public List<Event.EventType> getEventTypes() {
                return eventTypes;
            }

            public void setEventTypes(List<Event.EventType> eventTypes) {
                this.eventTypes = eventTypes;
            }
        }

        public static class ActuatorEvent {

            private List<GenerationType> actuatorsTypes;
            private List<Event.EventType> eventTypes;

            public List<GenerationType> getActuatorsTypes() {
                return actuatorsTypes;
            }

            public void setActuatorsTypes(List<GenerationType> actuatorsTypes) {
                this.actuatorsTypes = actuatorsTypes;
            }

            public List<Event.EventType> getEventTypes() {
                return eventTypes;
            }

            public void setEventTypes(List<Event.EventType> eventTypes) {
                this.eventTypes = eventTypes;
            }
        }
    }

    public enum GenerationType {
        NUMERICAL, BOOLEAN
    }

    public enum TransportType implements PluginSubType {
        HTTP, WS, KAFKA
    }

    public enum StorageType implements PluginSubType {
        CASSANDRA, MONGODB
    }

    public enum AnalyticsType implements PluginSubType {
        BASIC, ADVANCED, EXPERT
    }

    public enum PluginType {
        ANALYTICS, STORAGE, TRANSPORT
    }

    public interface PluginSubType {}


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public List<PluginDetail> getPlugins() {
        return plugins;
    }

    public void setPlugins(List<PluginDetail> plugins) {
        this.plugins = plugins;
    }
}
