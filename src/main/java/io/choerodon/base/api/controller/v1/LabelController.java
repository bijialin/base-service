package io.choerodon.base.api.controller.v1;

import io.choerodon.core.annotation.Permission;
import io.choerodon.core.enums.ResourceType;
import io.choerodon.core.base.BaseController;
import io.choerodon.base.app.service.LabelService;
import io.choerodon.base.infra.dto.LabelDTO;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author superlee
 */
@RestController
@RequestMapping(value = "/v1/labels")
public class LabelController extends BaseController {

    private LabelService labelService;

    public LabelController(LabelService labelService) {
        this.labelService = labelService;
    }

    @Permission(type = ResourceType.SITE)
    @ApiOperation(value = "通过类型查询label")
    @GetMapping
    public ResponseEntity<List<LabelDTO>> listByType(LabelDTO label) {
        return new ResponseEntity<>(labelService.listByOption(label), HttpStatus.OK);
    }

    @Permission(type = ResourceType.ORGANIZATION)
    @ApiOperation(value = "通过类型查询组织层label")
    @GetMapping(value = "/org/{organization_id}")
    public ResponseEntity<List<LabelDTO>> listByTypeAtOrg(@PathVariable(name = "organization_id") Long organizationId,
                                                          LabelDTO label) {
        label.setLevel(ResourceType.ORGANIZATION.value());
        return new ResponseEntity<>(labelService.listByOption(label), HttpStatus.OK);
    }

}
