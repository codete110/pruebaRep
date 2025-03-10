package org.iis2024;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Represents a calendar date with validation capabilities.
 *
 * This class encapsulates a date specified by day, month, and year components. It offers
 * functionality to validate the date against specific rules: the year must be within the range of
 * 1900 to 2050, inclusive; the month must be within 1 to 12, inclusive; and the day must be valid
 * within the context of the specified month and year, taking into account variations for leap
 * years.
 *
 * Instances of this class are immutable, meaning that once a Date object is created, the day,
 * month, and year values cannot be changed.
 */
public class Date {

  private int fieldAddedByJuanCarlos; // Campo agregado por Juan Carlos
  private final int day;
  private final int month;
  private final int year;

  /**
   * Constructor for the Date class.
   *
   * @param day   The day of the date.
   * @param month The month of the date.
   * @param year  The year of the date.
   */
  public Date(int day, int month, int year) {
    this.day = day;
    this.month = month;
    this.year = year;
    this.fieldAddedByJuanCarlos = 0; // Valor por defecto
  }

  /**
   * Getter for fieldAddedByJuanCarlos.
   *
   * @return The value of fieldAddedByJuanCarlos.
   */
  public int getFieldAddedByJuanCarlos() {
    return fieldAddedByJuanCarlos;
  }

  /**
   * Setter for fieldAddedByJuanCarlos.
   *
   * @param value The new value to set.
   */
  public void setFieldAddedByJuanCarlos(int value) {
    this.fieldAddedByJuanCarlos = value;
  }

  /**
   * Validates the date according to the predefined rules: the year must be within 1900 to 2050, the
   * month within 1 to 12, and the day valid within the given month and year, considering leap
   * years.
   *
   * This method utilizes {@link SimpleDateFormat} to parse the date, configured to be
   * non-lenient to ensure strict validation against the provided day, month, and year.
   *
   * @return true if the date is valid, false otherwise.
   */
  public boolean validate() {
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    dateFormat.setLenient(false);

    String dateString = String.format("%02d/%02d/%04d", day, month, year);

    try {
      dateFormat.parse(dateString);
      return (year >= 1900) && (year <= 2050);
    } catch (ParseException e) {
      return false;
    }
  }
}
