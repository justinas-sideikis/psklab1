package psklab1.entities.mybatis;

public class Driver {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.DRIVER.PIN
     *
     * @mbg.generated Mon Apr 08 22:15:17 EEST 2019
     */
    private String pin;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.DRIVER.NAME
     *
     * @mbg.generated Mon Apr 08 22:15:17 EEST 2019
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.DRIVER.TEAM_ID
     *
     * @mbg.generated Mon Apr 08 22:15:17 EEST 2019
     */
    private Integer teamId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.DRIVER.PIN
     *
     * @return the value of PUBLIC.DRIVER.PIN
     *
     * @mbg.generated Mon Apr 08 22:15:17 EEST 2019
     */
    public String getPin() {
        return pin;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.DRIVER.PIN
     *
     * @param pin the value for PUBLIC.DRIVER.PIN
     *
     * @mbg.generated Mon Apr 08 22:15:17 EEST 2019
     */
    public void setPin(String pin) {
        this.pin = pin;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.DRIVER.NAME
     *
     * @return the value of PUBLIC.DRIVER.NAME
     *
     * @mbg.generated Mon Apr 08 22:15:17 EEST 2019
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.DRIVER.NAME
     *
     * @param name the value for PUBLIC.DRIVER.NAME
     *
     * @mbg.generated Mon Apr 08 22:15:17 EEST 2019
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.DRIVER.TEAM_ID
     *
     * @return the value of PUBLIC.DRIVER.TEAM_ID
     *
     * @mbg.generated Mon Apr 08 22:15:17 EEST 2019
     */
    public Integer getTeamId() {
        return teamId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.DRIVER.TEAM_ID
     *
     * @param teamId the value for PUBLIC.DRIVER.TEAM_ID
     *
     * @mbg.generated Mon Apr 08 22:15:17 EEST 2019
     */
    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }
}