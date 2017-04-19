package mosing.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import mosing.model.JalurMasukModel;
import mosing.model.LokasiModel;

@Mapper
public interface JalurMasukMapper {
	
	@Select("select * from jalur_masuk where id_jalur = #{id_jalur}")
	JalurMasukModel selectJalurMasuk(@Param("id_jalur") int id_jalur);
	
	@Insert("INSERT INTO jalur_masuk (nama, tanggal_buka, tanggal_tutup,"
			+ "status, nama_jenjang, nama_program, persyaratan, flag_aktif) VALUES"
			+ "(#{nama}, #{tanggal_buka}, #{tanggal_tutup}, "
			+ "#{status}, #{nama_jenjang}, #{nama_program}, #{persyaratan}, #{flag_aktif})")
	void addJalurMasuk(JalurMasukModel jalur_masuk);
	
	@Update("UPDATE jalur_masuk SET nama = #{nama}, tanggal_buka=#{tanggal_buka}, tanggal_tutup=#{tanggal_tutup}, status=#{status}, "
			+ "nama_jenjang=#{nama_jenjang}, nama_program=#{nama_program}, persyaratan=#{persyaratan}, flag_aktif=#{flag_aktif} WHERE id_jalur=#{id_jalur}")
	void updateJalurMasuk(JalurMasukModel jalur_masuk);
	
	@Results(value = { 
    		@Result(property = "nama", column = "nama"), 
    		@Result(property = "tanggal_buka", column = "tanggal_buka"),
			@Result(property = "tanggal_tutup", column = "tanggal_tutup"),
			@Result(property = "status", column = "status"),
			@Result(property = "nama_jenjang", column = "nama_jenjang"),
			@Result(property = "nama_program", column = "nama_program"),
			@Result(property = "persyaratan", column = "persyaratan")})
	List<JalurMasukModel> selectAllJalurMasuk();
}
