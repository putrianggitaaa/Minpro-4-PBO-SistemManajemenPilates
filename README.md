# Sistem Manajemen Pilates - Geets Pilates Studio
**Putri Anggita Melasari | 2509116010**

## Deskripsi Program
Sistem Manajemen Pilates Geets Pilates Studio merupakan sebuah program yang dirancang untuk membantu proses pengelolaan data pada sebuah studio Pilates secara sederhana.
Program ini menyediakan beberapa menu yang dapat digunakan untuk mengelola informasi terkait Member, Instruktur, Jenis Kelas, dan Data Kelas Pilates. 
Sistem ini dapat membantu pengelola untuk memanajemen proses bisnis yang terdapat dalam Geets Pilates Studio.

## Struktur Packages
Program Sistem Manajemen Pilates menerapkan konsep MVC (Model, View, Controller) dengan membagi struktur program ke dalam beberapa package, yaitu model, view, dan controller. 
Pembagian ini digunakan untuk memisahkan pengelolaan data, proses pengolahan data, serta bagian utama yang menjalankan program. 

<img width="406" height="743" alt="image" src="https://github.com/user-attachments/assets/29937c05-e21c-47d1-8611-ae04c7db6c1d" />

Berikut adalah penjelasan dari masing-masing package yang ada didalam packages tersebut:

### 1. Package Config
Package Config berfungsi untuk menyimpan konfigurasi koneksi ke database MySQL.

### 2. Package Controller
Package controller berfungsi untuk mengatur alur proses dan logika interaksi antara bagian view, model, dan service. Controller menerima pilihan atau input dari pengguna melalui View, kemudian menjalankan proses sesuai dengan fitur yang dipilih.

### 3. Package Main
Package main merupakan bagian yang digunakan sebagai titik awal atau entry point dari program. 

### 4. Package Model
Package model berisi class yang digunakan untuk merepresentasikan objek dan data utama dalam sistem manajemen Pilates.

### 5. Package Service
Package service berisi class yang menangani proses pendukung dan validasi yang digunakan oleh sistem.

### 6. Package View
Package view bertanggung jawab terhadap tampilan dan interaksi langsung dengan pengguna. View digunakan untuk menampilkan menu, informasi data, serta meminta input dari pengguna.

## Alur Program
Alur program dimulai ketika pengguna menjalankan program melalui class Pilates.java sebagai class utama. Setelah program dijalankan, sistem akan menampilkan halaman utama  yang berisi beberapa pilihan menu.
Pengguna dapat memilih menu dengan menginput angka sesuai dengan pilihan yang tersedia. Sistem kemudian menggunakan percabangan switch-case untuk menentukan proses yang akan dijalankan.

Jika pengguna memilih menu Member, sistem akan mengarahkan pengguna ke proses lihat, tambah, update atau hapus data member. Jika memilih Instruktur, sistem akan mengarahkan pengguna ke proses lihat, tambah, update atau hapus data instruktur. Jika memilih Jenis Kelas, sistem akan mengarahkan pengguna ke proses lihat, tambah, update atau hapus data Jenis Kelas. Apabila pengguna memilih menu daftar kelas, maka akan diarahkan ke lihat daftar kelas yang sudah ada, menambahkan daftar kelas baru, menghapus daftar kelas yang sudah ada, dan melakukan update pada data daftar kelas. 

## Penerapan Encapsulation
Konsep encapsulation diterapkan pada class Member, Instruktur, JenisKelas, JenisKelasPrivate, JenisKelasPublik, dan KelasPilates dengan menjadikan atribut-atribut di dalamnya sebagai private. Atribut tersebut tidak dapat diakses secara langsung dari class lain, sehingga akses data dilakukan melalui getter dan setter yang telah disediakan. Selain itu, class Service juga menerapkan encapsulation pada atribut seperti daftarMember, daftarInstruktur, daftarJenisKelas, dan daftarKelas, sedangkan class InputValidator menerapkannya pada atribut scanner. Penggunaan encapsulation berfungsi untuk melindungi dan membatasi akses langsung terhadap data, sehingga perubahan maupun pengambilan data harus dilakukan melalui method yang telah ditentukan dan data menjadi lebih terkontrol.  

## Penerapan Inheritance
Inheritance dalam program ini diterapkan dengan membuat class JenisKelas.java yang bertindak sebagai Superclass dan class JenisKelasPrivate.java serta JenisKelasPublik.java yang bertindak sebagai Subclass. Kedua class yang bertindak sebagai Subclass tersebut mewarisi atribut dari Superclass nya, yaitu JenisKelas.java. Pada JenisKelasPrivate.java terdapat tambahan atribut khusus yaitu jenisSesi dan untuk JenisKelasPublik.java terdapat tambahan atribut khusus yaitu kapasitas. Pada masing-masing Subclass, diterapkan keyword 'super' untuk mengakses atribut dari Superclass nya. Selain itu, terdapat penerapan keyword 'final' pada atribut kapasitas dibagian InputValidator yang bertujuan untuk membatasi modifikasi pada atribut kapasitas sehingga pengguna dapat memasukkan kapasitas maksimal 25.

## Penerapan Polymorphism
Polymorphism dalam program ini diterapkan melalui method overriding pada class JenisKelasPrivate dan JenisKelasPublik yang merupakan Subclass dari JenisKelas. Kedua Subclass tersebut memiliki method yang sama dengan Superclass, tetapi dapat memberikan implementasi yang berbeda sesuai dengan karakteristik masing-masing jenis kelas. Dengan demikian, ketika method tersebut dipanggil melalui objek JenisKelas, program dapat menjalankan implementasi method sesuai dengan jenis objek yang digunakan. Penerapan polymorphism ini membuat program lebih fleksibel karena satu method dapat memiliki perilaku yang berbeda pada masing-masing Subclass.

Polymorphism dalam program ini juga diterapkan melalui method overloading pada class Service, yaitu pada method lihatInstruktur(String spesialisasi) yang digunakan untuk menampilkan data instruktur berdasarkan spesialisasi tertentu. Dengan adanya perbedaan parameter, method lihatInstruktur() dapat digunakan untuk menampilkan data instruktur secara umum maupun berdasarkan spesialisasi yang dipilih. Penerapan method overloading ini membuat program lebih fleksibel karena satu nama method dapat digunakan untuk menangani kebutuhan yang berbeda sesuai dengan parameter yang diberikan.

## Penerapan Abstraction
Abstraction dalam program ini diterapkan melalui abstract class JenisKelas dan abstract method tampilkanInfo(). Method tersebut menjadi aturan yang harus diimplementasikan oleh subclass seperti JenisKelasPrivate dan JenisKelasPublik. Dengan demikian, setiap jenis kelas dapat menampilkan informasi sesuai karakteristiknya masing-masing tanpa perlu mengetahui detail implementasinya.

## Penerapan Interface
Interface dalam program ini diterapkan melalui interface `CetakStruk` yang memiliki method `cetakStruk()`. Interface ini berfungsi sebagai kontrak yang menentukan bahwa class yang mengimplementasikannya harus memiliki method `cetakStruk()`. Pada program, struk akan dicetak setiap kali selesai melakukan pendaftaran kelas dan setelah melakukan update status kelas. Dengan demikian, interface `CetakStruk` membantu membuat proses pencetakan struk lebih terstruktur dan memastikan informasi dari setiap proses dapat ditampilkan kepada pengguna.
Program akan terus berjalan dan menampilkan kembali menu utama selama pengguna belum memilih menu Keluar. Dengan demikian, pengguna dapat melakukan beberapa proses pengelolaan data dalam satu kali menjalankan program.

## Penerapan JDBC
JDBC dalam program ini diterapkan untuk menghubungkan program dengan database MySQL. Penerapannya terdapat pada package `config`, melalui class `Koneksi.java` untuk mengatur koneksi database, serta package `model` yang berisi class DAO, yaitu `MemberDAO`, `InstrukturDAO`, `JenisKelasDAO`, dan `KelasPilatesDAO` untuk mengelola data masing-masing entitas.

Program ini menggunakan pengimplementasian `Connection` untuk mengakses database, `PreparedStatement` untuk menjalankan query SQL dengan parameter, dan `ResultSet` untuk membaca hasil query. JDBC mendukung operasi CRUD sehingga data member, instruktur, jenis kelas, dan sesi kelas dapat ditambahkan, ditampilkan, diperbarui, dan dihapus melaluiprogram serta tersimpan dalam database MySQL. Dengan adanya JDBC kita tidak perlu lagi menyimpan data dalam bentuk ArrayList karena penyimpanan data langsung ke database dan data tersimpan secara permanen bahkan ketika program telah berhenti.

## Dokumentasi Program 
Adapun dokumentasi dari alur program yaitu sebagai berikut:

### Tampilan Menu Utama

<img width="518" height="283" alt="image" src="https://github.com/user-attachments/assets/95e0733a-c314-4932-91c6-88afb3649132" />

Ketika program dijalankan, pengguna akan diberikan beberapa pilihan menu yang dapat digunakan untuk mengelola data. Terdapat menu member yang berfungsi untuk mengelola data member, menu Instruktur yang digunakan untuk mengelola data instruktur, menu jenis kelas yang digunakan untuk mengelola jenis kelas yang tersedia, serta menu pendaftaran kelas yang digunakan untuk mengelola daftar kelas yang akan dilaksanakan di studio pilates ini.

### Menu Member

<img width="382" height="285" alt="image" src="https://github.com/user-attachments/assets/e4176be8-9099-4075-b19f-290c77ac1bd3" />


Menu member berisi 5 sub menu yang fungsinya sebagai berikut:

* **1. Tambah Member**

<img width="468" height="505" alt="image" src="https://github.com/user-attachments/assets/24f8d195-d126-4268-bf33-8b18365d4bbe" />



Pada sub menu ini, pengguna dapat menambahkan member baru yang akan bergabung untuk mengikuti kelas di studio dengan memasukkan ID member, nama member, nomor telepon, usia dan jenis kelamin member tersebut.

* **2. Lihat Member**

<img width="468" height="858" alt="image" src="https://github.com/user-attachments/assets/48f92047-1392-42d6-aa5a-da3877066d4d" />


Pada sub menu ini, pengguna dapat melihat daftar member yang telah terdaftar pada sistem.

* **3. Update Status Member**

<img width="632" height="285" alt="image" src="https://github.com/user-attachments/assets/dc1f1bbc-2d59-45b3-bcfc-ddf3bc72fdd0" />

Pada sub menu ini, pengguna dapat mengubah status keaktifan dari member yang terdaftar dengan kategori Aktif dan Nonaktif.

* **4. Hapus Member**

<img width="527" height="121" alt="image" src="https://github.com/user-attachments/assets/282dff8d-b306-4843-91ab-0217b1fe162b" />

Pada sub menu ini, pengguna dapat menghapus member yang terdaftar dengan syarat member tersebut tidak terdapat dalam daftar kelas yang sedang berjalan.

* **5. Kembali**

<img width="525" height="352" alt="image" src="https://github.com/user-attachments/assets/8ec1b14b-ec97-4935-ac61-a2d34116469d" />


Pada sub menu ini, pengguna dapat kembali ke menu utama program.

### Menu Instruktur

<img width="483" height="266" alt="image" src="https://github.com/user-attachments/assets/b540aad6-a801-4386-bcd4-19a2dc4983b8" />

Menu instruktur berisi 6 sub menu yang fungsinya sebagai berikut:

* **1. Tambah Instruktur**

<img width="666" height="647" alt="image" src="https://github.com/user-attachments/assets/48943dbb-2e76-406e-a11f-fc120bf7370a" />


Pada sub menu ini, pengguna dapat menambahkan instruktur baru yang akan bergabung untuk memandu kelas di studio dengan memasukkan ID instruktur, nama instruktur, spesialisasi, nomor telepon, dan jenis kelamin instruktur tersebut.

* **2. Lihat Instruktur**

<img width="492" height="771" alt="image" src="https://github.com/user-attachments/assets/95c9fa0d-b58c-4a98-85df-6328e08124b2" />

Pada sub menu ini, pengguna dapat melihat daftar instruktur yang telah terdaftar pada sistem.

* **3. Lihat Instruktur Berdasarkan Spesialisasi**

<img width="512" height="426" alt="image" src="https://github.com/user-attachments/assets/1566e0e0-245a-4344-871d-29a78712667f" />

Pada sub menu ini, pengguna dapat melihat instruktur berdasarkan spesialisasi tertentu yang diinginkan. 

* **4. Update Status Instruktur**

<img width="522" height="275" alt="image" src="https://github.com/user-attachments/assets/3dcdd52e-0c4e-4fcd-a548-ae0b500a0e88" />

Pada sub menu ini, pengguna dapat mengubah status keaktifan dari Instruktur yang terdaftar dengan kategori Aktif dan Nonaktif.

* **5. Hapus Instruktur**
  
<img width="642" height="112" alt="image" src="https://github.com/user-attachments/assets/dd6a6c69-d2c4-4510-b526-fd44feaf7010" />

Pada sub menu ini, pengguna dapat menghapus instruktur yang terdaftar dengan syarat instruktur tersebut tidak terdapat dalam daftar kelas yang sedang berjalan.

* **6. Kembali**

<img width="517" height="352" alt="image" src="https://github.com/user-attachments/assets/74554fcc-abc5-4eeb-bc46-dced6c2fc5c5" />

Pada sub menu ini, pengguna dapat kembali ke menu utama program.

### Menu Jenis Kelas

<img width="457" height="276" alt="image" src="https://github.com/user-attachments/assets/89acfdad-a0ac-4813-88ba-1a344c881b27" />

Menu jenis kelas berisi 5 sub menu yang fungsinya sebagai berikut:

* **1. Tambah Jenis Kelas**
  
<img width="638" height="432" alt="image" src="https://github.com/user-attachments/assets/cf242ebe-0903-4954-81ca-292a06c05b52" />

Pada sub menu ini, pengguna dapat menambahkan jenis kelas baru yang akan diadakan di studio dengan memasukkan ID jenis, nama pilates, level, durasi, dan kapasitas dari jenis kelas tersebut.

* **2. Lihat Jenis Kelas**

<img width="467" height="857" alt="image" src="https://github.com/user-attachments/assets/76752c32-3f28-46cf-a7b5-1a1caff61f58" />


Pada sub menu ini, pengguna dapat melihat daftar jenis kelas yang telah terdaftar pada sistem.

* **3. Update Status Jenis Kelas**

<img width="547" height="272" alt="image" src="https://github.com/user-attachments/assets/89ae45c0-99a3-4c5d-9809-06b06a31f04e" />

Pada sub menu ini, pengguna dapat mengubah status keaktifan dari jenis kelas yang terdaftar dengan kategori Tersedia dan Tidak Tersedia.

* **4. Hapus Jenis Kelas**

<img width="595" height="110" alt="image" src="https://github.com/user-attachments/assets/3dd54d29-1f58-486f-8c7f-2bb58dbc1d28" />

Pada sub menu ini, pengguna dapat menghapus jenis kelas yang terdaftar dengan syarat jenis kelas tersebut tidak terdapat dalam daftar kelas yang sedang berjalan.

* **5. Kembali**

<img width="540" height="382" alt="image" src="https://github.com/user-attachments/assets/cdeb9425-f20a-46b2-9836-a9e3baf57d28" />

Pada sub menu ini, pengguna dapat kembali ke menu utama program.

### Menu Daftar Kelas

<img width="452" height="357" alt="image" src="https://github.com/user-attachments/assets/40f7f843-634d-4c53-8dc6-9c5ad252c3b2" />

Menu pendaftaran kelas berisi 5 sub menu yang fungsinya sebagai berikut:

* **1. Daftar Kelas**

<img width="622" height="358" alt="image" src="https://github.com/user-attachments/assets/7eb6f5e7-d15d-4047-9c2c-617f3f3d9dfd" />

Pada sub menu ini, pengguna dapat mendaftarkan member, instruktur, dan jenis kelas kedalams sebuah sesi kelas. Setelah pendaftaran berhasil, program akan menampilkan output berupa struk sebagai perwujudan dari interface CetakStruk()

* **2. Lihat Pendaftar Kelas**

<img width="528" height="552" alt="image" src="https://github.com/user-attachments/assets/4c59f909-3e98-4a69-afc7-59d1019bc5fc" />

Pada sub menu ini, pengguna dapat melihat daftar kelas yang telah terdaftar pada sistem dan siap untuk dilaksanakan pada studio. Data ini berisi identitas member yang melaksanakan kelas, instruktur yang memandu kelas, jenis kelas yang dilaksanakan dan waktunya.

* **3. Update Kelas**

<img width="530" height="365" alt="image" src="https://github.com/user-attachments/assets/447fc1f0-ef26-46ae-b168-a8e28f6fed11" />

Pada sub menu ini, sistem akan mengarahkan pengguna untuk melakukan update terhadap status kelas yang ada. Update bisa berupa Terjadwal, Selesai, atau Batal. Sub Menu ini berguna untuk memudahkan pengelola dalam menandai status kelas yang telah terdaftar.

Pada sub menu ini, sistem akan mengarahkan pengguna untuk menginput ID kelas yang akan dihapus. Selanjutnya, sistem akan menghapus kelas sesuai dengan ID yang di input oleh pengguna. Sub menu ini dapat digunakan apabila sesi kelas telah selesai dilaksanakan dan member tidak ingin memperpanjang sesi kelas nya kembali.

* **4. Hapus Kelas**

<img width="487" height="85" alt="image" src="https://github.com/user-attachments/assets/259e467b-2df5-4d60-912a-ea5930216311" />

Pada sub menu ini, sistem akan mengarahkan pengguna untuk menginput ID kelas yang akan dihapus. Selanjutnya, sistem akan menghapus kelas sesuai dengan ID yang di input oleh pengguna. Sub menu ini dapat digunakan apabila sesi kelas telah selesai dilaksanakan dan member tidak ingin memperpanjang sesi kelas nya kembali.

* **5. Kembali**
  
<img width="510" height="372" alt="image" src="https://github.com/user-attachments/assets/389eefe6-7d21-4ed7-bf5b-7afcb7ac2ccf" />

Pada sub menu ini, pengguna dapat kembali ke menu utama program.


  
### Menu Keluar dari Program

<img width="546" height="383" alt="image" src="https://github.com/user-attachments/assets/c7940cde-24b4-4325-af4c-033e5569263d" />

Pada menu ini, pengguna dapat menghentikan program.
