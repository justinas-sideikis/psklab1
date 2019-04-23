package psklab1.persistence.mybatis;

import java.util.List;

import org.mybatis.cdi.Mapper;
import psklab1.entities.mybatis.Team;

@Mapper
public interface TeamMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.TEAM
     *
     * @mbg.generated Mon Apr 08 22:15:17 EEST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.TEAM
     *
     * @mbg.generated Mon Apr 08 22:15:17 EEST 2019
     */
    int insert(Team record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.TEAM
     *
     * @mbg.generated Mon Apr 08 22:15:17 EEST 2019
     */
    Team selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.TEAM
     *
     * @mbg.generated Mon Apr 08 22:15:17 EEST 2019
     */
    List<Team> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.TEAM
     *
     * @mbg.generated Mon Apr 08 22:15:17 EEST 2019
     */
    int updateByPrimaryKey(Team record);
}