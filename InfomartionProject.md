# Game Store API - Backend Portfolio

##  Deskripsi
Project ini merupakan REST API yang digunakan untuk mengelola data game dalam sebuah sistem Game Store. Sistem ini dibuat untuk menggantikan pencatatan manual menjadi sistem digital yang lebih efisien dan terstruktur.

---

## Tujuan
- Mempermudah pengelolaan data game  
- Mengurangi kesalahan pencatatan  
- Menyediakan backend system yang scalable  

---

## Latar Belakang
Dalam sistem manual, pengelolaan data game sering kali tidak efisien dan rentan terhadap kesalahan. Oleh karena itu, diperlukan sistem backend yang mampu mengelola data secara otomatis dan terstruktur.

---

## Cara Kerja Sistem
Sistem bekerja dengan menerima request dari client dan memprosesnya melalui beberapa layer:

Client → Controller → Service → Repository → Database

---

## Arsitektur
- Controller → menerima request  
- Service → logic bisnis  
- Repository → akses database  
- Entity → representasi data  

---

## Fitur API

### Game
- GET /games
- GET /games/{id}
- POST /games
- PUT /games/{id}
- DELETE /games/{id}
- POST /games/{id}/buy

---

## Security (JWT)
Sistem menggunakan JWT untuk mengamankan endpoint.

Flow:
1. User register  
2. User login → mendapatkan token  
3. Token digunakan untuk akses API  

---

## Database
Menggunakan MySQL dengan JPA/Hibernate.

---

## Testing
Pengujian dilakukan menggunakan Postman untuk memastikan semua endpoint berjalan dengan baik.

---

## Evaluasi

### Kelebihan
- Struktur clean architecture  
- Menggunakan JWT untuk keamanan  
- API modular dan scalable  

### Kekurangan
- Belum menggunakan enkripsi password  
- Belum ada role user  

### Pengembangan
- Implementasi bcrypt  
- Role-based authorization  
- Integrasi frontend  

---

## Author
Fakhri Zul Aufar
