/**
 * ***************************************************************************** Turnstone Biologics
 * Confidential
 *
 * <p>2018 Turnstone Biologics All Rights Reserved.
 *
 * <p>This file is subject to the terms and conditions defined in file 'license.txt', which is part
 * of this source code package.
 *
 * <p>Contributors : Turnstone Biologics - General Release
 * ****************************************************************************
 */
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentboundaryprofile.core.validator;

import com.occulue.api.*;
import com.occulue.validator.*;
import org.springframework.util.Assert;

public class EquipmentContainerValidator {

  /** default constructor */
  protected EquipmentContainerValidator() {}

  /** factory method */
  public static EquipmentContainerValidator getInstance() {
    return new EquipmentContainerValidator();
  }

  /** handles creation validation for a EquipmentContainer */
  public void validate(CreateEquipmentContainerCommand equipmentContainer) throws Exception {
    Assert.notNull(equipmentContainer, "CreateEquipmentContainerCommand should not be null");
    //		Assert.isNull( equipmentContainer.getEquipmentContainerId(),
    // "CreateEquipmentContainerCommand identifier should be null" );
  }

  /** handles update validation for a EquipmentContainer */
  public void validate(UpdateEquipmentContainerCommand equipmentContainer) throws Exception {
    Assert.notNull(equipmentContainer, "UpdateEquipmentContainerCommand should not be null");
    Assert.notNull(
        equipmentContainer.getEquipmentContainerId(),
        "UpdateEquipmentContainerCommand identifier should not be null");
  }

  /** handles delete validation for a EquipmentContainer */
  public void validate(DeleteEquipmentContainerCommand equipmentContainer) throws Exception {
    Assert.notNull(equipmentContainer, "{commandAlias} should not be null");
    Assert.notNull(
        equipmentContainer.getEquipmentContainerId(),
        "DeleteEquipmentContainerCommand identifier should not be null");
  }

  /** handles fetchOne validation for a EquipmentContainer */
  public void validate(EquipmentContainerFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "EquipmentContainerFetchOneSummary should not be null");
    Assert.notNull(
        summary.getEquipmentContainerId(),
        "EquipmentContainerFetchOneSummary identifier should not be null");
  }
}
