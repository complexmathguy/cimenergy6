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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.userdefinedmodels.validator;

import com.occulue.api.*;
import com.occulue.validator.*;
import org.springframework.util.Assert;

public class WindType3or4UserDefinedValidator {

  /** default constructor */
  protected WindType3or4UserDefinedValidator() {}

  /** factory method */
  public static WindType3or4UserDefinedValidator getInstance() {
    return new WindType3or4UserDefinedValidator();
  }

  /** handles creation validation for a WindType3or4UserDefined */
  public void validate(CreateWindType3or4UserDefinedCommand windType3or4UserDefined)
      throws Exception {
    Assert.notNull(
        windType3or4UserDefined, "CreateWindType3or4UserDefinedCommand should not be null");
    //		Assert.isNull( windType3or4UserDefined.getWindType3or4UserDefinedId(),
    // "CreateWindType3or4UserDefinedCommand identifier should be null" );
  }

  /** handles update validation for a WindType3or4UserDefined */
  public void validate(UpdateWindType3or4UserDefinedCommand windType3or4UserDefined)
      throws Exception {
    Assert.notNull(
        windType3or4UserDefined, "UpdateWindType3or4UserDefinedCommand should not be null");
    Assert.notNull(
        windType3or4UserDefined.getWindType3or4UserDefinedId(),
        "UpdateWindType3or4UserDefinedCommand identifier should not be null");
  }

  /** handles delete validation for a WindType3or4UserDefined */
  public void validate(DeleteWindType3or4UserDefinedCommand windType3or4UserDefined)
      throws Exception {
    Assert.notNull(windType3or4UserDefined, "{commandAlias} should not be null");
    Assert.notNull(
        windType3or4UserDefined.getWindType3or4UserDefinedId(),
        "DeleteWindType3or4UserDefinedCommand identifier should not be null");
  }

  /** handles fetchOne validation for a WindType3or4UserDefined */
  public void validate(WindType3or4UserDefinedFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "WindType3or4UserDefinedFetchOneSummary should not be null");
    Assert.notNull(
        summary.getWindType3or4UserDefinedId(),
        "WindType3or4UserDefinedFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Proprietary validation for a WindType3or4UserDefined
   *
   * @param command AssignProprietaryToWindType3or4UserDefinedCommand
   */
  public void validate(AssignProprietaryToWindType3or4UserDefinedCommand command) throws Exception {
    Assert.notNull(command, "AssignProprietaryToWindType3or4UserDefinedCommand should not be null");
    Assert.notNull(
        command.getWindType3or4UserDefinedId(),
        "AssignProprietaryToWindType3or4UserDefinedCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignProprietaryToWindType3or4UserDefinedCommand assignment should not be null");
  }

  /**
   * handles unassign Proprietary validation for a WindType3or4UserDefined
   *
   * @param command UnAssignProprietaryFromWindType3or4UserDefinedCommand
   */
  public void validate(UnAssignProprietaryFromWindType3or4UserDefinedCommand command)
      throws Exception {
    Assert.notNull(
        command, "UnAssignProprietaryFromWindType3or4UserDefinedCommand should not be null");
    Assert.notNull(
        command.getWindType3or4UserDefinedId(),
        "UnAssignProprietaryFromWindType3or4UserDefinedCommand identifier should not be null");
  }
}
