package KhanhVySang.demo.Service.ThongTinCaNhan;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import KhanhVySang.demo.Model.Form.KhachHang.FormThongTinKhachHang;
import KhanhVySang.demo.Model.ThongTinCaNhan.KhachHangModel;
import KhanhVySang.demo.Repositories.Form.KhachHang.ViewThongTinKhachHang;
import KhanhVySang.demo.Repositories.ThongTinCaNhan.KhachHangRepository;

@Service
public class KhachHangService {

    @Autowired
    private KhachHangRepository khachHangRepository;
    @Autowired
    private ViewThongTinKhachHang viewThongTinKhachHang;

    public List<KhachHangModel> findAll(){
        return khachHangRepository.findAll();
    }

    public KhachHangModel findByMaKhachHang(int maKhachHang){

        Optional<KhachHangModel> oKH = khachHangRepository.findByMaKhachHang(maKhachHang);
        KhachHangModel kh = new KhachHangModel();

        if(oKH.isEmpty()) return kh;

        return oKH.get();
    }

    public KhachHangModel findByDienThoai(String dienThoai){

        Optional<KhachHangModel> oKH = khachHangRepository.findByDienThoai(dienThoai);
        KhachHangModel kh = new KhachHangModel();

        if(oKH.isEmpty()) return kh;

        return oKH.get();
    }

    public List<KhachHangModel> findByHo(String ho){
        return khachHangRepository.findByHo(ho);
    }

    public List<KhachHangModel> findByTen(String ten){
        return khachHangRepository.findByHo(ten);
    }

    public List<KhachHangModel> findByGioiTinh(String gioiTinh){
        return khachHangRepository.findByHo(gioiTinh);
    }

    public List<KhachHangModel> findByHo(Date ngaySinh){
        return khachHangRepository.findByNgaySinh(ngaySinh);
    }

    public KhachHangModel findByMaTaiKhoan(int maTaiKhoan){
        return khachHangRepository.findByMaTaiKhoan(maTaiKhoan).isPresent() ?
            khachHangRepository.findByMaTaiKhoan(maTaiKhoan).get():
            new KhachHangModel();
    }

    public List<FormThongTinKhachHang> findAllByForm(){
        return viewThongTinKhachHang.findAll();
    }

    public boolean InsertKhachHang(KhachHangModel khachHang){
        try {
            return khachHangRepository.InsertKhachHang(khachHang.getHo(), 
                                                       khachHang.getTen(), 
                                                       khachHang.getGioiTinh(),
                                                       khachHang.getDienThoai(), 
                                                       khachHang.getNgaySinh(), 
                                                       khachHang.getMaTaiKhoan());
        } catch (Exception e) {
            return false;
        }
    }

    public boolean UpdateKhachHang(KhachHangModel khachHang){
        try {
            return khachHangRepository.InsertKhachHang(khachHang.getHo(), 
                                                       khachHang.getTen(), 
                                                       khachHang.getGioiTinh(),
                                                       khachHang.getDienThoai(), 
                                                       khachHang.getNgaySinh(), 
                                                       khachHang.getMaTaiKhoan());
        } catch (Exception e) {
            return false;
        }
    }

}
