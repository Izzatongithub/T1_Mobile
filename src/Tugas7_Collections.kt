//nama: Izzat Nazhiefa
//NIM: F1D02310114
//Mobile B

data class NilaiMhs(
    val nim: String,
    val nama: String,
    val mataKuliah: String,
    val nilai: Int
)

fun getGrade(nilai: Int): String {
    return when {
        nilai >= 85 -> "A"
        nilai >= 70 -> "B"
        nilai >= 60 -> "C"
        nilai >= 50 -> "D"
        else -> "E"
    }
}

fun main() {

    val daftarMhs = listOf(
        NilaiMhs("2024001", "Budi Santoso", "Pemrograman", 85),
        NilaiMhs("2024002", "Ani Wijaya", "Pemrograman", 92),
        NilaiMhs("2024003", "Citra Dewi", "Pemrograman", 68),
        NilaiMhs("2024004", "Bimo", "Pemrograman", 45),
        NilaiMhs("2024005", "Ahmet", "Pemrograman", 74),
        NilaiMhs("2024006", "Dudung", "Pemrograman", 88),
        NilaiMhs("2024007", "Maman", "Pemrograman", 55),
        NilaiMhs("2024008", "Asep", "Pemrograman", 79),
        NilaiMhs("2024009", "Ujang", "Pemrograman", 63),
        NilaiMhs("2024010", "Izzat", "Pemrograman", 90)
    )

    println("===== DATA NILAI MAHASISWA =====")
    println("No  NIM      Nama              MataKuliah    Nilai")

    daftarMhs.forEachIndexed { index, mhs ->
        println("${index+1}  ${mhs.nim}  ${mhs.nama}  ${mhs.mataKuliah}  ${mhs.nilai}")
    }

    // filter mhs lulus
    val lulus = daftarMhs.filter { mhs -> mhs.nilai >= 70 }

    // filter mhs tdk lulus
    val tidakLulus = daftarMhs.filter { mhs -> mhs.nilai < 70 }

    // rata2 nilai mhs
    val rataRata = daftarMhs.map { mhs -> mhs.nilai }.average()

    // nilai tertinggi mhs
    val tertinggi = daftarMhs.maxByOrNull { mhs -> mhs.nilai }

    // nilai terendah mhs
    val terendah = daftarMhs.minByOrNull { mhs -> mhs.nilai }

    println("\n===== STATISTIK =====")
    println("Total Mahasiswa : ${daftarMhs.size}")
    println("Rata-rata Nilai : $rataRata")
    println("Nilai Tertinggi : ${tertinggi?.nilai} (${tertinggi?.nama})")
    println("Nilai Terendah  : ${terendah?.nilai} (${terendah?.nama})")

    println("\n===== MAHASISWA LULUS =====")
    lulus.forEachIndexed { index, mhs ->
        println("${index+1}. ${mhs.nama} - ${mhs.nilai} (${getGrade(mhs.nilai)})")
    }

    println("\n===== MAHASISWA TIDAK LULUS =====")
    tidakLulus.forEachIndexed { index, mhs ->
        println("${index+1}. ${mhs.nama} - ${mhs.nilai} (${getGrade(mhs.nilai)})")
    }

    // sort asc nilai
    val ascending = daftarMhs.sortedBy { mhs-> mhs.nilai }

    println("\n===== URUT NILAI ASCENDING =====")
    ascending.forEach { mhs ->
        println("${mhs.nama} - ${mhs.nilai}")
    }

    // sort desc nilai
    val descending = daftarMhs.sortedByDescending { mhs -> mhs.nilai }

    println("\n===== URUT NILAI DESCENDING =====")
    descending.forEach { mhs ->
        println("${mhs.nama} - ${mhs.nilai}")
    }

    // group by nilai
    val kelompokGrade = daftarMhs.groupBy { mhs -> getGrade(mhs.nilai) }

    println("\n===== JUMLAH PER GRADE =====")
    kelompokGrade.forEach { (grade, list) ->
        println("Grade $grade : ${list.size} mahasiswa")
    }

    // cari nama mhs
    val keyword = "iz"
    val hasilCari = daftarMhs.filter { mhs ->
        mhs.nama.contains(keyword, ignoreCase = true) }

    println("\n===== HASIL PENCARIAN NAMA \"$keyword\" =====")
    hasilCari.forEach { mhs ->
        println("${mhs.nama} - ${mhs.nilai}")
    }
}