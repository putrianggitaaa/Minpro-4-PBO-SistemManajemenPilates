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
