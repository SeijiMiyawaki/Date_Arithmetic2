package repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import domain.DateArithmetic;

@Mapper
public interface DateArithmeticRepository {
	@Select("SELECT * FROM datearithmetic ORDER BY dateId ASC")
	List<DateArithmetic> select();
	
	@Select("SELECT * FROM datearithmetic WHERE dateId = #{dateId}")
	DateArithmetic selectPK(String dateId);
	
	@Insert("INSERT INTO datearithmetic VALUES(#{dateId}, #{dateName}, #{adjustmentYear}, #{adjustmentMonth}, #{adjustmentDay}")
	void insert(DateArithmetic form);
	
	@Update("UPDATE datearithmetic SET dateName = #{dateName}, adjustmentYear = #{adjustmentYear}, adjustmentMonth = #{adjustmentMonth}, adjustmentDay = #{adjustmentDay}")
	void update(DateArithmetic form);
	
	@Delete("DELETE FROM datearithmetic WHERE dateId = #{dateId}")
	void deletePK(String dateId);
}
