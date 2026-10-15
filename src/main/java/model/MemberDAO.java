
package model;

import config.Koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.function.Consumer;

public class MemberDAO {

  
    public void forEach(Consumer<Member> aksi) throws SQLException {
        String sql = "SELECT * FROM member ORDER BY id_member";

        try (Connection conn = Koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Member member = new Member(
                    rs.getInt("id_member"),
                    rs.getString("nama"),
                    rs.getString("no_telepon"),
                    rs.getInt("usia"),
                    rs.getString("jenis_kelamin"),
                    rs.getString("status")
                );

                aksi.accept(member);
            }
        }
    }

  
    public Member findById(int id) throws SQLException {
        String sql = "SELECT * FROM member WHERE id_member = ?";

        try (Connection conn = Koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Member(
                        rs.getInt("id_member"),
                        rs.getString("nama"),
                        rs.getString("no_telepon"),
                        rs.getInt("usia"),
                        rs.getString("jenis_kelamin"),
                        rs.getString("status")
                    );
                }
            }
        }

        return null;
    }

    public boolean existsById(int id) throws SQLException {
        String sql = "SELECT 1 FROM member "
                   + "WHERE id_member = ? LIMIT 1";

        try (Connection conn = Koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        }
    }

    
    public boolean isUsedInKelas(int id) throws SQLException {
        String sql = "SELECT 1 FROM kelas_pilates "
                   + "WHERE id_member = ? LIMIT 1";

        try (Connection conn = Koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        }
    }

    
    public boolean insert(Member member) throws SQLException {
        String sql = "INSERT INTO member "
                   + "(id_member, nama, no_telepon, usia, "
                   + "jenis_kelamin, status) "
                   + "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = Koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, member.getIdMember());
            ps.setString(2, member.getNamaMember());
            ps.setString(3, member.getNoTelepon());
            ps.setInt(4, member.getUsia());
            ps.setString(5, member.getJenisKelamin());
            ps.setString(6, member.getStatus());

            return ps.executeUpdate() > 0;
        }
    }

   
    public boolean updateStatus(int id, String status)
            throws SQLException {

        String sql = "UPDATE member SET status = ? "
                   + "WHERE id_member = ?";

        try (Connection conn = Koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, status);
            ps.setInt(2, id);

            return ps.executeUpdate() > 0;
        }
    }

   
    public boolean delete(int id) throws SQLException {
        String sql = "DELETE FROM member WHERE id_member = ?";

        try (Connection conn = Koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            return ps.executeUpdate() > 0;
        }
    }
}
