package mosing.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import mosing.model.PenyeleksianModel;

@Mapper
public interface PenyeleksianMapper {

	@Insert("insert into penyeleksian (no_daftar, status, id_jalur, berkas) values (#{no_daftar}, #{status}, #{id_jalur}, #{berkas})")
	void addPenyeleksian(PenyeleksianModel penyeleksian);

	@Select("select * from penyeleksian where id_jalur = #{id_jalur}")
	PenyeleksianModel selectPenyeleksian(@Param("id_jalur") int id_jalur);
	
	@Select("select p.* from penyeleksian p where p.no_daftar = #{no_daftar}")
	PenyeleksianModel selectPenyeleksian2(@Param("no_daftar") int no_daftar);
	
	@Update("update penyeleksian set berkas=#{berkas} where no_daftar=#{no_daftar}")
	void updateBerkas(@Param("berkas") String berkas, @Param("no_daftar") int no_daftar);
	
	@Select("select * from penyeleksian")
	List<PenyeleksianModel> selectAllPenyeleksian();
}