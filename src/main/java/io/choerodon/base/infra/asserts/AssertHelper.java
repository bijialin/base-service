package io.choerodon.base.infra.asserts;

import io.choerodon.core.exception.ext.EmptyParamException;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

/**
 * @author superlee
 * @since 2019-05-13
 */
@Component
public class AssertHelper {

    public void objectVersionNumberNotNull(Long objectVersionNumber) {
        objectVersionNumberNotNull(objectVersionNumber, "error.objectVersionNumber.null");
    }

    public void objectVersionNumberNotNull(Long objectVersionNumber, String message) {
        if (ObjectUtils.isEmpty(objectVersionNumber)) {
            throw new EmptyParamException(message);
        }
    }
}
