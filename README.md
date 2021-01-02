# PresensiRestFullAPI

#Berjalan Pada Port 5060<br>
#Database MySQL<br>
#Database Port 8889<br>
#Database Username : root<br>
#Database Password : root<br>

Web Service<br>

Registrasi siswa baru<br> 
method:POST http://localhost:5060/api/student/register<br>
{<br>
    "idProdi":"1",<br>
    "name":"Faiz Ahnaf Eka Putra",<br>
    "password":"Ahnaffaiz",<br>
    "gender":"Laki-laki",<br>
}<br>

Login (Mencari data Siswa Berdasarkan username dan password)<br>
method:POST http://localhost:5060/api/student/login<br>
{<br>
    "name":"Faiz Ahnaf Eka Putra",<br>
    "password":"Ahnaffaiz"<br>
}<br>
<br>
Presensi Masuk (Mencatat Presensi Siswa Berdasarkan Id)<br>
method:GET http://localhost:5060/api/presensi/{idStudent}<br>
<br>
Menampilkan Seluruh Presensi<br>
method:GET http://localhost:5060/api/presensi/showall<br>
<br>
-------------------------------------------------------------------------------<br>
Fitur Tambahan<br>

Menambahkan Alamat Siswa<br>
method:POST http://localhost:5060/api/student/address/{idStudent}<br>
{<br>
    "alamat":"Kentingan, Jebres, Surakarta"<br>
}<br>

Menampilkan Alamat Siswa berdasarkan idStudent<br>
method:GET http://localhost:5060/api/student/address/{idStudent}<br>
<br>
Menambahkan Email Siswa<br>
method:POST http://localhost:5060/api/student/mail/{idStudent}<br>
{<br>
    "email":"faizahnaf@mail.com"<br>
}<br>
<br>
Menampilkan Email Siswa berdasarkan idStudent<br>
method:GET http://localhost:5060/api/student/mail/{idStudent}<br>

Menambahkan Prodi<br>
method:POST http://localhost:5060/api/prodi/add-prodi<br>
{<br>
    "prodi":"Pendidikan Bahasa Inggris"<br>
}<br>
<br>
Menampilkan Semua Prodi<br>
method:GET http::/localhost:5060/api/prodi/showall<br>


