package mosing.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import mosing.model.PendaftarModel;

@Mapper
public interface PendaftarMapper {

	@Select("select * from pendaftar where no_id = ${no_id}")
	PendaftarModel selectPendaftar(@Param("no_id") String no_id);

	@Insert("INSERT INTO pendaftar (username, password, email, role, no_id, nama_id, "
			+ "nama_ijazah, foto, no_hp, no_telp, negara, kewarganegaraan, alamat_tetap, "
			+ "jenis_id, alamat_sekarang, tgl_lahir, provinsi, kota, jenis_kelamin) VALUES"
			+ "(#{username}, #{password}, #{email}, #{role}, #{no_id}, #{nama_id}, "
			+ "#{nama_ijazah}, #{foto}, #{no_hp}, #{no_telp}, #{negara}, #{kewarganegaraan},"
			+ "#{alamat_tetap}, #{jenis_id}, #{alamat_sekarang}, #{tgl_lahir}, #{provinsi}, "
			+ "#{kota}, #{jenis_kelamin})")
	void addPendaftar(PendaftarModel pendaftar);
}