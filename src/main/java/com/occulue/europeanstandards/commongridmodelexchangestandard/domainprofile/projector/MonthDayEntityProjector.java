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
package com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Projector for MonthDay as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by MonthDayAggregate
 *
 * @author your_name_here
 */
@Component("monthDay-entity-projector")
public class MonthDayEntityProjector {

  // core constructor
  public MonthDayEntityProjector(MonthDayRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a MonthDay
   *
   * @param	entity MonthDay
   */
  public MonthDay create(MonthDay entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a MonthDay
   *
   * @param	entity MonthDay
   */
  public MonthDay update(MonthDay entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a MonthDay
   *
   * @param	id		UUID
   */
  public MonthDay delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    MonthDay entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /**
   * Method to retrieve the MonthDay via an FindMonthDayQuery
   *
   * @return query FindMonthDayQuery
   */
  @SuppressWarnings("unused")
  public MonthDay find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a MonthDay - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all MonthDays
   *
   * @param query FindAllMonthDayQuery
   * @return List<MonthDay>
   */
  @SuppressWarnings("unused")
  public List<MonthDay> findAll(FindAllMonthDayQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all MonthDay - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final MonthDayRepository repository;

  @Autowired
  @Qualifier(value = "monthDayInterval-entity-projector")
  MonthDayIntervalEntityProjector MonthDayIntervalProjector;

  @Autowired
  @Qualifier(value = "season-entity-projector")
  SeasonEntityProjector SeasonProjector;

  private static final Logger LOGGER = Logger.getLogger(MonthDayEntityProjector.class.getName());
}
