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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardinterconnections.validator;

import com.occulue.api.*;
import com.occulue.validator.*;
import org.springframework.util.Assert;

public class StaticpowersystemmodelValidator {

  /** default constructor */
  protected StaticpowersystemmodelValidator() {}

  /** factory method */
  public static StaticpowersystemmodelValidator getInstance() {
    return new StaticpowersystemmodelValidator();
  }

  /** handles creation validation for a Staticpowersystemmodel */
  public void validate(CreateStaticpowersystemmodelCommand staticpowersystemmodel)
      throws Exception {
    Assert.notNull(
        staticpowersystemmodel, "CreateStaticpowersystemmodelCommand should not be null");
    //		Assert.isNull( staticpowersystemmodel.getStaticpowersystemmodelId(),
    // "CreateStaticpowersystemmodelCommand identifier should be null" );
  }

  /** handles update validation for a Staticpowersystemmodel */
  public void validate(UpdateStaticpowersystemmodelCommand staticpowersystemmodel)
      throws Exception {
    Assert.notNull(
        staticpowersystemmodel, "UpdateStaticpowersystemmodelCommand should not be null");
    Assert.notNull(
        staticpowersystemmodel.getStaticpowersystemmodelId(),
        "UpdateStaticpowersystemmodelCommand identifier should not be null");
  }

  /** handles delete validation for a Staticpowersystemmodel */
  public void validate(DeleteStaticpowersystemmodelCommand staticpowersystemmodel)
      throws Exception {
    Assert.notNull(staticpowersystemmodel, "{commandAlias} should not be null");
    Assert.notNull(
        staticpowersystemmodel.getStaticpowersystemmodelId(),
        "DeleteStaticpowersystemmodelCommand identifier should not be null");
  }

  /** handles fetchOne validation for a Staticpowersystemmodel */
  public void validate(StaticpowersystemmodelFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "StaticpowersystemmodelFetchOneSummary should not be null");
    Assert.notNull(
        summary.getStaticpowersystemmodelId(),
        "StaticpowersystemmodelFetchOneSummary identifier should not be null");
  }
}
