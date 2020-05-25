package com.tsimul;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tsimul.exception.ConfigurationException;

/**
 * TODO: Remove this class
 */
public abstract class AbstractIOTSystemBuilder {

    public IOTSystem build() throws ConfigurationException, JsonProcessingException {
        throw new UnsupportedOperationException("This system does not support this method yet");
    }
}
