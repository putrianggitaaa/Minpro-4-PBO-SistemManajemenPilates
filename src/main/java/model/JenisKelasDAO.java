package model;

import config.Koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.function.Consumer;

public class JenisKelasDAO {

    private static final String SELECT_JOIN =
        "SELECT jk.*, jp.jenis_sesi, jpu.kapasitas " +
        "FROM jenis_kelas jk " +
        "LEFT JOIN jenis_kelas_private jp ON jk.id_jenis = jp.id_jenis " +
        "LEFT JOIN jenis_kelas_publik jpu ON jk.id_jenis = jpu.id_jenis ";

    public void forEach(Consumer<JenisKelas> aksi) throws SQLException {
        String sql = SELECT_JOIN + "ORDER BY jk.id_jenis";
        try (Connection conn = Koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                JenisKelas jenis = bacaJenisKelas(rs);
                if (jenis != null) aksi.accept(jenis);
            }
        }
    }

    private JenisKelas bacaJenisKelas(ResultSet rs) throws SQLException {
        int id = rs.getInt("id_jenis");
        String nama = rs.getString("nama");
        String level = rs.getString("level");
        String durasi = rs.getString("durasi");
        String status = rs.getString("status");
        String jenisSesi = rs.getString("jenis_sesi");
        Object kapasitas = rs.getObject("kapasitas");

        if (jenisSesi != null) {
            return new JenisKelasPrivate(id, nama, level, durasi, jenisSesi, status);
        }
        if (kapasitas != null) {
            return new JenisKelasPublik(id, nama, level, durasi, rs.getInt("kapasitas"), status);
        }
        return null;
    }

    public JenisKelas findById(int idJenis) throws SQLException {
        String sql = SELECT_JOIN + "WHERE jk.id_jenis = ?";
        try (Connection conn = Koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idJenis);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return bacaJenisKelas(rs);
            }
        }
        return null;
    }

    public boolean existsById(int idJenis) throws SQLException {
        String sql = "SELECT 1 FROM jenis_kelas WHERE id_jenis = ? LIMIT 1";
        try (Connection conn = Koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idJenis);
            try (ResultSet rs = ps.executeQuery()) { return rs.next(); }
        }
    }

    public boolean isUsedInKelas(int idJenis) throws SQLException {
        String sql = "SELECT 1 FROM kelas_pilates WHERE id_jenis = ? LIMIT 1";
        try (Connection conn = Koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idJenis);
            try (ResultSet rs = ps.executeQuery()) { return rs.next(); }
        }
    }

    public boolean insertPrivate(JenisKelasPrivate jenis) throws SQLException {
        String sqlJenis = "INSERT INTO jenis_kelas (id_jenis, nama, level, durasi, status) VALUES (?, ?, ?, ?, ?)";
        String sqlPrivate = "INSERT INTO jenis_kelas_private (id_jenis, jenis_sesi) VALUES (?, ?)";
        try (Connection conn = Koneksi.getConnection()) {
            conn.setAutoCommit(false);
            try {
                try (PreparedStatement ps = conn.prepareStatement(sqlJenis)) {
                    ps.setInt(1, jenis.getIdJenis());
                    ps.setString(2, jenis.getNamaJenis());
                    ps.setString(3, jenis.getLevel());
                    ps.setString(4, jenis.getDurasi());
                    ps.setString(5, jenis.getStatus());
                    ps.executeUpdate();
                }
                try (PreparedStatement ps = conn.prepareStatement(sqlPrivate)) {
                    ps.setInt(1, jenis.getIdJenis());
                    ps.setString(2, jenis.getJenisSesi());
                    ps.executeUpdate();
                }
                conn.commit();
                return true;
            } catch (SQLException e) {
                conn.rollback();
                throw e;
            } finally {
                conn.setAutoCommit(true);
            }
        }
    }

    public boolean insertPublik(JenisKelasPublik jenis) throws SQLException {
        String sqlJenis = "INSERT INTO jenis_kelas (id_jenis, nama, level, durasi, status) VALUES (?, ?, ?, ?, ?)";
        String sqlPublik = "INSERT INTO jenis_kelas_publik (id_jenis, kapasitas) VALUES (?, ?)";
        try (Connection conn = Koneksi.getConnection()) {
            conn.setAutoCommit(false);
            try {
                try (PreparedStatement ps = conn.prepareStatement(sqlJenis)) {
                    ps.setInt(1, jenis.getIdJenis());
                    ps.setString(2, jenis.getNamaJenis());
                    ps.setString(3, jenis.getLevel());
                    ps.setString(4, jenis.getDurasi());
                    ps.setString(5, jenis.getStatus());
                    ps.executeUpdate();
                }
                try (PreparedStatement ps = conn.prepareStatement(sqlPublik)) {
                    ps.setInt(1, jenis.getIdJenis());
                    ps.setInt(2, jenis.getKapasitas());
                    ps.executeUpdate();
                }
                conn.commit();
                return true;
            } catch (SQLException e) {
                conn.rollback();
                throw e;
            } finally {
                conn.setAutoCommit(true);
            }
        }
    }

    public boolean updateStatus(int idJenis, String status) throws SQLException {
        String sql = "UPDATE jenis_kelas SET status = ? WHERE id_jenis = ?";
        try (Connection conn = Koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, status);
            ps.setInt(2, idJenis);
            return ps.executeUpdate() > 0;
        }
    }

    public boolean delete(int idJenis) throws SQLException {
        String sqlPrivate = "DELETE FROM jenis_kelas_private WHERE id_jenis = ?";
        String sqlPublik = "DELETE FROM jenis_kelas_publik WHERE id_jenis = ?";
        String sqlJenis = "DELETE FROM jenis_kelas WHERE id_jenis = ?";
        try (Connection conn = Koneksi.getConnection()) {
            conn.setAutoCommit(false);
            try {
                try (PreparedStatement ps = conn.prepareStatement(sqlPrivate)) {
                    ps.setInt(1, idJenis); ps.executeUpdate();
                }
                try (PreparedStatement ps = conn.prepareStatement(sqlPublik)) {
                    ps.setInt(1, idJenis); ps.executeUpdate();
                }
                int hasil;
                try (PreparedStatement ps = conn.prepareStatement(sqlJenis)) {
                    ps.setInt(1, idJenis); hasil = ps.executeUpdate();
                }
                conn.commit();
                return hasil > 0;
            } catch (SQLException e) {
                conn.rollback();
                throw e;
            } finally {
                conn.setAutoCommit(true);
            }
        }
    }
}
