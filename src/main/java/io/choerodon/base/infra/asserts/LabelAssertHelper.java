package io.choerodon.base.infra.asserts;

import io.choerodon.base.infra.dto.LabelDTO;
import io.choerodon.core.exception.ext.NotExistedException;
import io.choerodon.base.infra.mapper.LabelMapper;
import org.springframework.stereotype.Component;

/**
 * label断言类
 *
 * @author superlee
 * @since 2019-07-15
 */
@Component
public class LabelAssertHelper extends AssertHelper {

    private LabelMapper labelMapper;

    public  LabelAssertHelper (LabelMapper labelMapper) {
        this.labelMapper = labelMapper;
    }

    public LabelDTO labelNotExisted(Long id) {
        return labelNotExisted(id, "error.label.not.exist");
    }

    public LabelDTO labelNotExisted(Long id, String message) {
        LabelDTO dto = labelMapper.selectByPrimaryKey(id);
        if(dto == null) {
            throw new NotExistedException(message);
        }
        return dto;
    }
}
