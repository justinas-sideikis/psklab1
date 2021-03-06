package psklab1.persistence.mybatis;

import java.util.List;

import org.mybatis.cdi.Mapper;
import psklab1.entities.mybatis.Stage;

@Mapper
public interface StageMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.STAGE
     *
     * @mbg.generated Mon Apr 08 22:15:17 EEST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.STAGE
     *
     * @mbg.generated Mon Apr 08 22:15:17 EEST 2019
     */
    int insert(Stage record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.STAGE
     *
     * @mbg.generated Mon Apr 08 22:15:17 EEST 2019
     */
    Stage selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.STAGE
     *
     * @mbg.generated Mon Apr 08 22:15:17 EEST 2019
     */
    List<Stage> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.STAGE
     *
     * @mbg.generated Mon Apr 08 22:15:17 EEST 2019
     */
    int updateByPrimaryKey(Stage record);
}