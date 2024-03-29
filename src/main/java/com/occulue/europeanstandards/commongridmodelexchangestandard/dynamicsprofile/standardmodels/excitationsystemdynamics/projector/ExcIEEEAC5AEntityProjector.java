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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.excitationsystemdynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.excitationsystemdynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for ExcIEEEAC5A as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by ExcIEEEAC5AAggregate
 *
 * @author your_name_here
 */
@Component("excIEEEAC5A-entity-projector")
public class ExcIEEEAC5AEntityProjector {

  // core constructor
  public ExcIEEEAC5AEntityProjector(ExcIEEEAC5ARepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a ExcIEEEAC5A
   *
   * @param	entity ExcIEEEAC5A
   */
  public ExcIEEEAC5A create(ExcIEEEAC5A entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a ExcIEEEAC5A
   *
   * @param	entity ExcIEEEAC5A
   */
  public ExcIEEEAC5A update(ExcIEEEAC5A entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a ExcIEEEAC5A
   *
   * @param	id		UUID
   */
  public ExcIEEEAC5A delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    ExcIEEEAC5A entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a Efd1
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcIEEEAC5A
   */
  public ExcIEEEAC5A assignEfd1(UUID parentId, PU assignment) {
    LOGGER.info("assigning Efd1 as " + assignment.toString());

    ExcIEEEAC5A parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Efd1 to the parent entity
    // ------------------------------------------
    parentEntity.setEfd1(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Efd1
   *
   * @param	parentId		UUID
   * @return	ExcIEEEAC5A
   */
  public ExcIEEEAC5A unAssignEfd1(UUID parentId) {
    ExcIEEEAC5A parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Efd1 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Efd1 on the parent entithy
    // ------------------------------------------
    parentEntity.setEfd1(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Efd2
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcIEEEAC5A
   */
  public ExcIEEEAC5A assignEfd2(UUID parentId, PU assignment) {
    LOGGER.info("assigning Efd2 as " + assignment.toString());

    ExcIEEEAC5A parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Efd2 to the parent entity
    // ------------------------------------------
    parentEntity.setEfd2(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Efd2
   *
   * @param	parentId		UUID
   * @return	ExcIEEEAC5A
   */
  public ExcIEEEAC5A unAssignEfd2(UUID parentId) {
    ExcIEEEAC5A parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Efd2 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Efd2 on the parent entithy
    // ------------------------------------------
    parentEntity.setEfd2(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Ka
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcIEEEAC5A
   */
  public ExcIEEEAC5A assignKa(UUID parentId, PU assignment) {
    LOGGER.info("assigning Ka as " + assignment.toString());

    ExcIEEEAC5A parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Ka to the parent entity
    // ------------------------------------------
    parentEntity.setKa(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ka
   *
   * @param	parentId		UUID
   * @return	ExcIEEEAC5A
   */
  public ExcIEEEAC5A unAssignKa(UUID parentId) {
    ExcIEEEAC5A parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ka on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ka on the parent entithy
    // ------------------------------------------
    parentEntity.setKa(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Ke
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcIEEEAC5A
   */
  public ExcIEEEAC5A assignKe(UUID parentId, PU assignment) {
    LOGGER.info("assigning Ke as " + assignment.toString());

    ExcIEEEAC5A parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Ke to the parent entity
    // ------------------------------------------
    parentEntity.setKe(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ke
   *
   * @param	parentId		UUID
   * @return	ExcIEEEAC5A
   */
  public ExcIEEEAC5A unAssignKe(UUID parentId) {
    ExcIEEEAC5A parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ke on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ke on the parent entithy
    // ------------------------------------------
    parentEntity.setKe(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kf
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcIEEEAC5A
   */
  public ExcIEEEAC5A assignKf(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kf as " + assignment.toString());

    ExcIEEEAC5A parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kf to the parent entity
    // ------------------------------------------
    parentEntity.setKf(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kf
   *
   * @param	parentId		UUID
   * @return	ExcIEEEAC5A
   */
  public ExcIEEEAC5A unAssignKf(UUID parentId) {
    ExcIEEEAC5A parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kf on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kf on the parent entithy
    // ------------------------------------------
    parentEntity.setKf(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Seefd1
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	ExcIEEEAC5A
   */
  public ExcIEEEAC5A assignSeefd1(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Seefd1 as " + assignment.toString());

    ExcIEEEAC5A parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Seefd1 to the parent entity
    // ------------------------------------------
    parentEntity.setSeefd1(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Seefd1
   *
   * @param	parentId		UUID
   * @return	ExcIEEEAC5A
   */
  public ExcIEEEAC5A unAssignSeefd1(UUID parentId) {
    ExcIEEEAC5A parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Seefd1 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Seefd1 on the parent entithy
    // ------------------------------------------
    parentEntity.setSeefd1(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Seefd2
   *
   * @param	parentId	UUID
   * @param	assignment 	Simple_Float
   * @return	ExcIEEEAC5A
   */
  public ExcIEEEAC5A assignSeefd2(UUID parentId, Simple_Float assignment) {
    LOGGER.info("assigning Seefd2 as " + assignment.toString());

    ExcIEEEAC5A parentEntity = repository.findById(parentId).get();
    assignment = Simple_FloatProjector.find(assignment.getSimple_FloatId());

    // ------------------------------------------
    // assign the Seefd2 to the parent entity
    // ------------------------------------------
    parentEntity.setSeefd2(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Seefd2
   *
   * @param	parentId		UUID
   * @return	ExcIEEEAC5A
   */
  public ExcIEEEAC5A unAssignSeefd2(UUID parentId) {
    ExcIEEEAC5A parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Seefd2 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Seefd2 on the parent entithy
    // ------------------------------------------
    parentEntity.setSeefd2(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Ta
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	ExcIEEEAC5A
   */
  public ExcIEEEAC5A assignTa(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Ta as " + assignment.toString());

    ExcIEEEAC5A parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Ta to the parent entity
    // ------------------------------------------
    parentEntity.setTa(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ta
   *
   * @param	parentId		UUID
   * @return	ExcIEEEAC5A
   */
  public ExcIEEEAC5A unAssignTa(UUID parentId) {
    ExcIEEEAC5A parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ta on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ta on the parent entithy
    // ------------------------------------------
    parentEntity.setTa(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Te
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	ExcIEEEAC5A
   */
  public ExcIEEEAC5A assignTe(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Te as " + assignment.toString());

    ExcIEEEAC5A parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Te to the parent entity
    // ------------------------------------------
    parentEntity.setTe(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Te
   *
   * @param	parentId		UUID
   * @return	ExcIEEEAC5A
   */
  public ExcIEEEAC5A unAssignTe(UUID parentId) {
    ExcIEEEAC5A parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Te on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Te on the parent entithy
    // ------------------------------------------
    parentEntity.setTe(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tf1
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	ExcIEEEAC5A
   */
  public ExcIEEEAC5A assignTf1(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tf1 as " + assignment.toString());

    ExcIEEEAC5A parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tf1 to the parent entity
    // ------------------------------------------
    parentEntity.setTf1(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tf1
   *
   * @param	parentId		UUID
   * @return	ExcIEEEAC5A
   */
  public ExcIEEEAC5A unAssignTf1(UUID parentId) {
    ExcIEEEAC5A parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tf1 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tf1 on the parent entithy
    // ------------------------------------------
    parentEntity.setTf1(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tf2
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	ExcIEEEAC5A
   */
  public ExcIEEEAC5A assignTf2(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tf2 as " + assignment.toString());

    ExcIEEEAC5A parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tf2 to the parent entity
    // ------------------------------------------
    parentEntity.setTf2(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tf2
   *
   * @param	parentId		UUID
   * @return	ExcIEEEAC5A
   */
  public ExcIEEEAC5A unAssignTf2(UUID parentId) {
    ExcIEEEAC5A parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tf2 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tf2 on the parent entithy
    // ------------------------------------------
    parentEntity.setTf2(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tf3
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	ExcIEEEAC5A
   */
  public ExcIEEEAC5A assignTf3(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tf3 as " + assignment.toString());

    ExcIEEEAC5A parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tf3 to the parent entity
    // ------------------------------------------
    parentEntity.setTf3(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tf3
   *
   * @param	parentId		UUID
   * @return	ExcIEEEAC5A
   */
  public ExcIEEEAC5A unAssignTf3(UUID parentId) {
    ExcIEEEAC5A parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tf3 on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tf3 on the parent entithy
    // ------------------------------------------
    parentEntity.setTf3(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vrmax
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcIEEEAC5A
   */
  public ExcIEEEAC5A assignVrmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vrmax as " + assignment.toString());

    ExcIEEEAC5A parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vrmax to the parent entity
    // ------------------------------------------
    parentEntity.setVrmax(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vrmax
   *
   * @param	parentId		UUID
   * @return	ExcIEEEAC5A
   */
  public ExcIEEEAC5A unAssignVrmax(UUID parentId) {
    ExcIEEEAC5A parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vrmax on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vrmax on the parent entithy
    // ------------------------------------------
    parentEntity.setVrmax(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vrmin
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcIEEEAC5A
   */
  public ExcIEEEAC5A assignVrmin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vrmin as " + assignment.toString());

    ExcIEEEAC5A parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vrmin to the parent entity
    // ------------------------------------------
    parentEntity.setVrmin(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vrmin
   *
   * @param	parentId		UUID
   * @return	ExcIEEEAC5A
   */
  public ExcIEEEAC5A unAssignVrmin(UUID parentId) {
    ExcIEEEAC5A parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vrmin on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vrmin on the parent entithy
    // ------------------------------------------
    parentEntity.setVrmin(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the ExcIEEEAC5A via an FindExcIEEEAC5AQuery
   *
   * @return query FindExcIEEEAC5AQuery
   */
  @SuppressWarnings("unused")
  public ExcIEEEAC5A find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a ExcIEEEAC5A - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all ExcIEEEAC5As
   *
   * @param query FindAllExcIEEEAC5AQuery
   * @return List<ExcIEEEAC5A>
   */
  @SuppressWarnings("unused")
  public List<ExcIEEEAC5A> findAll(FindAllExcIEEEAC5AQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all ExcIEEEAC5A - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final ExcIEEEAC5ARepository repository;

  @Autowired
  @Qualifier(value = "pU-entity-projector")
  PUEntityProjector PUProjector;

  @Autowired
  @Qualifier(value = "simple_Float-entity-projector")
  Simple_FloatEntityProjector Simple_FloatProjector;

  @Autowired
  @Qualifier(value = "seconds-entity-projector")
  SecondsEntityProjector SecondsProjector;

  private static final Logger LOGGER = Logger.getLogger(ExcIEEEAC5AEntityProjector.class.getName());
}
