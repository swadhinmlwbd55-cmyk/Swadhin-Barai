package com.example.data.repository

import com.example.data.model.District

object DistrictData {
    val districts: List<District> = listOf(
        // ঢাকা বিভাগ (১-১৩)
        District(
            id = 1, serialNo = 1, nameBn = "ঢাকা", nameEn = "Dhaka", division = "ঢাকা",
            soilType = "পলি দোআঁশ ও লালচে এঁটেল মাটি",
            features = "শাকসবজি, ফুল ও আধুনিক কৃষিখামার",
            cropIds = listOf("shaksobji", "dhan_boro", "dhan_aman", "kola_pepe", "sorisha")
        ),
        District(
            id = 2, serialNo = 2, nameBn = "গাজীপুর", nameEn = "Gazipur", division = "ঢাকা",
            soilType = "মধুপুর গড়ের লাল মাটি ও বেলে দোআঁশ",
            features = "কাঁঠাল, আনারস, পেঁপে ও সবজি চাষের জন্য বিখ্যাত",
            cropIds = listOf("kola_pepe", "shaksobji", "dhan_aman", "sorisha")
        ),
        District(
            id = 3, serialNo = 3, nameBn = "নারায়ণগঞ্জ", nameEn = "Narayanganj", division = "ঢাকা",
            soilType = "মেঘনা ও শীতলক্ষ্যা অববাহিকার উর্বর পলি দোআঁশ",
            features = "পাট, শাকসবজি ও বোরো ধান উৎপাদন",
            cropIds = listOf("pat", "shaksobji", "dhan_boro", "sorisha")
        ),
        District(
            id = 4, serialNo = 4, nameBn = "নরসিংদী", nameEn = "Narsingdi", division = "ঢাকা",
            soilType = "উর্বর বেলে দোআঁশ ও পলি মাটি",
            features = "অমৃতসাগর কলা, লটকন ও উন্নত জাতের সবজির শীর্ষ জেলা",
            cropIds = listOf("kola_pepe", "shaksobji", "pat", "dhan_boro")
        ),
        District(
            id = 5, serialNo = 5, nameBn = "মানিকগঞ্জ", nameEn = "Manikganj", division = "ঢাকা",
            soilType = "ধলেশ্বরী ও পদ্মা বিধৌত উর্বর পলি মাটি",
            features = "সরিষা, তামাক, পাট ও উন্নত জাতের রবি শস্য",
            cropIds = listOf("sorisha", "pat", "alu", "dhan_boro", "masur")
        ),
        District(
            id = 6, serialNo = 6, nameBn = "মুন্সীগঞ্জ", nameEn = "Munshiganj", division = "ঢাকা",
            soilType = "উর্বর পলি দোআঁশ মাটি (আলুর প্রধান অঞ্চল)",
            features = "বাংলাদেশের সর্বোচ্চ আলু ও কলা উৎপাদনকারী অন্যতম জেলা",
            cropIds = listOf("alu", "pat", "kola_pepe", "dhan_boro", "shaksobji")
        ),
        District(
            id = 7, serialNo = 7, nameBn = "টাঙ্গাইল", nameEn = "Tangail", division = "ঢাকা",
            soilType = "যমুনা অববাহিকার পলি ও লালচে দোআঁশ মাটি",
            features = "আনারস, আমন ধান, সরিষা ও বিভিন্ন মসলাজাতীয় ফসল",
            cropIds = listOf("sorisha", "dhan_aman", "dhan_boro", "pat", "kola_pepe")
        ),
        District(
            id = 8, serialNo = 8, nameBn = "কিশোরগঞ্জ", nameEn = "Kishoreganj", division = "ঢাকা",
            soilType = "হাওর এলাকার গভীর পলি ও কাদা মাটি",
            features = "বিশাল হাওর এলাকায় বিপুল পরিমাণ বোরো ধান উৎপাদন",
            cropIds = listOf("dhan_boro", "sorisha", "pat", "masur", "shaksobji")
        ),
        District(
            id = 9, serialNo = 9, nameBn = "ফরিদপুর", nameEn = "Faridpur", division = "ঢাকা",
            soilType = "পদ্মা বিধৌত উর্বর পলি দোআঁশ মাটি",
            features = "বিশ্বখ্যাত সোনালী আঁশ পাট ও পেঁয়াজ উৎপাদনের প্রাণকেন্দ্র",
            cropIds = listOf("pat", "peyaj", "sorisha", "masur", "dhan_aman")
        ),
        District(
            id = 10, serialNo = 10, nameBn = "রাজবাড়ী", nameEn = "Rajbari", division = "ঢাকা",
            soilType = "পলি দোআঁশ ও এঁটেল দোআঁশ মাটি",
            features = "পাট, পেঁয়াজ, রসুন ও মসুর ডাল চাষে অগ্রণী",
            cropIds = listOf("peyaj", "pat", "masur", "sorisha", "dhan_boro")
        ),
        District(
            id = 11, serialNo = 11, nameBn = "গোপালগঞ্জ", nameEn = "Gopalganj", division = "ঢাকা",
            soilType = "বিল প্রধান অঞ্চল ও পলি এঁটেল মাটি",
            features = "বোরো ধান, ভাসমান বেডে সবজি ও তরমুজ চাষ",
            cropIds = listOf("dhan_boro", "tormuj", "shaksobji", "pat")
        ),
        District(
            id = 12, serialNo = 12, nameBn = "মাদারীপুর", nameEn = "Madaripur", division = "ঢাকা",
            soilType = "পলি ও দোআঁশ মাটি",
            features = "পাট, সরিষা, খেজুরের গুড় ও রবি ফসল",
            cropIds = listOf("pat", "sorisha", "dhan_boro", "masur")
        ),
        District(
            id = 13, serialNo = 13, nameBn = "শরীয়তপুর", nameEn = "Shariatpur", division = "ঢাকা",
            soilType = "পলি চরাঞ্চল ও দোআঁশ মাটি",
            features = "মরিচ, পেঁয়াজ, রসুন, পাট ও রবি ফসল",
            cropIds = listOf("morich", "peyaj", "pat", "sorisha", "dhan_boro")
        ),

        // চট্টগ্রাম বিভাগ (১৪-২৪)
        District(
            id = 14, serialNo = 14, nameBn = "চট্টগ্রাম", nameEn = "Chattogram", division = "চট্টগ্রাম",
            soilType = "উপকূলীয় পলি ও পাহাড়ি বেলে দোআঁশ মাটি",
            features = "রোপা আমন ধান, চা, তরমুজ ও বিভিন্ন ফলমূল",
            cropIds = listOf("dhan_aman", "cha", "tormuj", "kola_pepe", "shaksobji")
        ),
        District(
            id = 15, serialNo = 15, nameBn = "কক্সবাজার", nameEn = "Cox's Bazar", division = "চট্টগ্রাম",
            soilType = "উপকূলীয় বালুময় ও পাহাড়ি দোআঁশ মাটি",
            features = "মিষ্টি পান, সুপারী, লবণাক্ততা সহনশীল ধান ও তরমুজ",
            cropIds = listOf("tamak_o_pan", "tormuj", "dhan_aman", "shaksobji")
        ),
        District(
            id = 16, serialNo = 16, nameBn = "কুমিল্লা", nameEn = "Cumilla", division = "চট্টগ্রাম",
            soilType = "উর্বর লাল মাটি ও গোমতী অববাহিকার পলি",
            features = "সবজি, ধান ও সরিষা চাষে সমৃদ্ধ কৃষি অঞ্চল",
            cropIds = listOf("shaksobji", "dhan_boro", "dhan_aman", "sorisha", "alu")
        ),
        District(
            id = 17, serialNo = 17, nameBn = "চাঁদপুর", nameEn = "Chandpur", division = "চট্টগ্রাম",
            soilType = "মেঘনা অববাহিকার উর্বর পলি দোআঁশ",
            features = "সয়াবিন, মরিচ, আলু ও বোরো ধান",
            cropIds = listOf("alu", "morich", "dhan_boro", "surjomukhi_badam")
        ),
        District(
            id = 18, serialNo = 18, nameBn = "ব্রাহ্মণবাড়িয়া", nameEn = "Brahmanbaria", division = "চট্টগ্রাম",
            soilType = "তিতাস ও মেঘনা বিধৌত পলি মাটি",
            features = "বোরো ধান, পাট ও শীতকালীন শাকসবজি",
            cropIds = listOf("dhan_boro", "pat", "shaksobji", "sorisha")
        ),
        District(
            id = 19, serialNo = 19, nameBn = "নোয়াখালী", nameEn = "Noakhali", division = "চট্টগ্রাম",
            soilType = "উপকূলীয় চরাঞ্চল ও নোনা পলি মাটি",
            features = "সয়াবিন, বাদাম, নারিকেল, সুপারি ও আমন ধান",
            cropIds = listOf("surjomukhi_badam", "dhan_aman", "tamak_o_pan", "tormuj")
        ),
        District(
            id = 20, serialNo = 20, nameBn = "ফেনী", nameEn = "Feni", division = "চট্টগ্রাম",
            soilType = "পলি দোআঁশ ও উপকূলীয় মাটি",
            features = "আমন ধান, শাকসবজি ও তরমুজ চাষ",
            cropIds = listOf("dhan_aman", "tormuj", "shaksobji", "dhan_boro")
        ),
        District(
            id = 21, serialNo = 21, nameBn = "লক্ষ্মীপুর", nameEn = "Lakshmipur", division = "চট্টগ্রাম",
            soilType = "উপকূলীয় পলি ও বেলে দোআঁশ মাটি",
            features = "বাংলাদেশের সয়াবিন ও সুপারির রাজধানী",
            cropIds = listOf("surjomukhi_badam", "tamak_o_pan", "morich", "dhan_aman")
        ),
        District(
            id = 22, serialNo = 22, nameBn = "খাগড়াছড়ি", nameEn = "Khagrachhari", division = "চট্টগ্রাম",
            soilType = "পাহাড়ি লাল মাটি ও উপত্যকার দোআঁশ",
            features = "আম্রপালি আম, আনারস, কলা, আদা ও হলুদ",
            cropIds = listOf("aam", "kola_pepe", "morich", "dhan_aman")
        ),
        District(
            id = 23, serialNo = 23, nameBn = "রাঙ্গামাটি", nameEn = "Rangamati", division = "চট্টগ্রাম",
            soilType = "পাহাড়ি লালচে কাঁকরযুক্ত ও দোআঁশ মাটি",
            features = "জুম চাষ, তুলা, পাহাড়ি ফল ও মসলা চাষ",
            cropIds = listOf("tula", "aam", "kola_pepe", "morich")
        ),
        District(
            id = 24, serialNo = 24, nameBn = "বান্দরবান", nameEn = "Bandarban", division = "চট্টগ্রাম",
            soilType = "উঁচু পাহাড়ি দোআঁশ ও লাল মাটি",
            features = "কফি, কাজুবাদাম, পাহাড়ি কলা, পেঁপে ও ফলবাগান",
            cropIds = listOf("kola_pepe", "aam", "tula", "morich")
        ),

        // রাজশাহী বিভাগ (২৫-৩২)
        District(
            id = 25, serialNo = 25, nameBn = "রাজশাহী", nameEn = "Rajshahi", division = "রাজশাহী",
            soilType = "বরেন্দ্র অঞ্চলের শক্ত লালচে এঁটেল ও পলি দোআঁশ",
            features = "আমের রাজধানী হিসেবে খ্যাত, উন্নত জাতের ধান ও রেশম",
            cropIds = listOf("aam", "dhan_boro", "gom", "pat", "shaksobji")
        ),
        District(
            id = 26, serialNo = 26, nameBn = "চাঁপাইনবাবগঞ্জ", nameEn = "Chapai Nawabganj", division = "রাজশাহী",
            soilType = "বরেন্দ্র ও পদ্মা চরাঞ্চলের দোআঁশ মাটি",
            features = "ফজলি, ক্ষীরশাপাত ও ল্যাংড়া আমের বিশ্বখ্যাত উৎপাদন কেন্দ্র",
            cropIds = listOf("aam", "gom", "dhan_boro", "masur", "sorisha")
        ),
        District(
            id = 27, serialNo = 27, nameBn = "নওগাঁ", nameEn = "Naogaon", division = "রাজশাহী",
            soilType = "বরেন্দ্র অঞ্চলের সমতল এঁটেল দোআঁশ মাটি",
            features = "বাংলাদেশের সর্ববৃহৎ ধান ও চালের ভাণ্ডার, আম ও সরিষা",
            cropIds = listOf("dhan_boro", "dhan_aman", "aam", "sorisha", "gom")
        ),
        District(
            id = 28, serialNo = 28, nameBn = "নাটোর", nameEn = "Natore", division = "রাজশাহী",
            soilType = "চলনবিল এলাকার উর্বর পলি ও দোআঁশ মাটি",
            features = "রসুন, চিনি উৎপাদনের আখ, আম ও চালের সমৃদ্ধ কেন্দ্র",
            cropIds = listOf("peyaj", "akher_chash", "aam", "dhan_boro", "pat")
        ),
        District(
            id = 29, serialNo = 29, nameBn = "পাবনা", nameEn = "Pabna", division = "রাজশাহী",
            soilType = "পদ্মা ও যমুনা বিধৌত পলি দোআঁশ মাটি",
            features = "পেঁয়াজ, দুধ, ডাল ও শাকসবজি উৎপাদনে শীর্ষ",
            cropIds = listOf("peyaj", "masur", "sorisha", "gom", "dhan_boro")
        ),
        District(
            id = 30, serialNo = 30, nameBn = "সিরাজগঞ্জ", nameEn = "Sirajganj", division = "রাজশাহী",
            soilType = "যমুনার উর্বর চর ও পলি মাটি",
            features = "সরিষা, পাট, গম ও চরাঞ্চলের বাদাম চাষ",
            cropIds = listOf("sorisha", "pat", "gom", "surjomukhi_badam", "dhan_boro")
        ),
        District(
            id = 31, serialNo = 31, nameBn = "বগুড়া", nameEn = "Bogura", division = "রাজশাহী",
            soilType = "করতোয়া বিধৌত দোআঁশ ও এঁটেল মাটি",
            features = "সবজি, আলু, লাল মরিচ ও উন্নত বীজের বৃহত্তম পাইকারি কেন্দ্র",
            cropIds = listOf("alu", "morich", "shaksobji", "dhan_boro", "bhutta")
        ),
        District(
            id = 32, serialNo = 32, nameBn = "জয়পুরহাট", nameEn = "Joypurhat", division = "রাজশাহী",
            soilType = "উর্বর বেলে দোআঁশ ও এঁটেল দোআঁশ",
            features = "আলু, আখ ও মুরগির খামার সমৃদ্ধ কৃষি অঞ্চল",
            cropIds = listOf("alu", "akher_chash", "dhan_boro", "sorisha")
        ),

        // খুলনা বিভাগ (৩৩-৪২)
        District(
            id = 33, serialNo = 33, nameBn = "খুলনা", nameEn = "Khulna", division = "খুলনা",
            soilType = "উপকূলীয় নোনা এঁটেল ও পলি দোআঁশ",
            features = "লবণাক্ততাসহিষ্ণু আমন ধান, নারিকেল, গোলপাতা ও সবজি",
            cropIds = listOf("dhan_aman", "tormuj", "shaksobji", "tamak_o_pan")
        ),
        District(
            id = 34, serialNo = 34, nameBn = "বাগেরহাট", nameEn = "Bagerhat", division = "খুলনা",
            soilType = "উপকূলীয় পলি ও নোনা দোআঁশ",
            features = "সুপারি, নারিকেল, গলদা চিংড়ির ঘেরে ধান ও তরমুজ",
            cropIds = listOf("tamak_o_pan", "tormuj", "dhan_aman", "shaksobji")
        ),
        District(
            id = 35, serialNo = 35, nameBn = "সাতক্ষীরা", nameEn = "Satkhira", division = "খুলনা",
            soilType = "উপকূলীয় নোনা এঁটেল মাটি",
            features = "হিমসাগর আম, কুল, লবণসহিষ্ণু ব্রি ধান ও মাছের ঘেরে চাষ",
            cropIds = listOf("aam", "dhan_aman", "kola_pepe", "shaksobji")
        ),
        District(
            id = 36, serialNo = 36, nameBn = "যশোর", nameEn = "Jashore", division = "খুলনা",
            soilType = "উর্বর বেলে দোআঁশ ও পলি দোআঁশ মাটি",
            features = "গদখালী ফুলের রাজধানী, খেজুর গুড় ও আগাম শাকসবজি",
            cropIds = listOf("shaksobji", "dhan_boro", "pat", "masur", "sorisha")
        ),
        District(
            id = 37, serialNo = 37, nameBn = "ঝিনাইদহ", nameEn = "Jhenaidah", division = "খুলনা",
            soilType = "উর্বর দোআঁশ ও বেলে দোআঁশ",
            features = "কলা, পেঁপে, পটল, মরিচ ও ড্রাগন ফলের শীর্ষ জেলা",
            cropIds = listOf("kola_pepe", "morich", "shaksobji", "pat", "akher_chash")
        ),
        District(
            id = 38, serialNo = 38, nameBn = "মাগুরা", nameEn = "Magura", division = "খুলনা",
            soilType = "নবগঙ্গা বিধৌত পলি দোআঁশ",
            features = "সরিষা, পাট, মসুর ডাল ও পেঁয়াজ চাষে সমৃদ্ধ",
            cropIds = listOf("sorisha", "pat", "masur", "peyaj", "dhan_boro")
        ),
        District(
            id = 39, serialNo = 39, nameBn = "নড়াইল", nameEn = "Narail", division = "খুলনা",
            soilType = "চিত্রা বিধৌত উর্বর পলি মাটি",
            features = "পাট, ধান ও মিষ্টি পানির মৎস্য-কৃষি মিশ্র খামার",
            cropIds = listOf("pat", "dhan_boro", "sorisha", "masur")
        ),
        District(
            id = 40, serialNo = 40, nameBn = "কুষ্টিয়া", nameEn = "Kushtia", division = "খুলনা",
            soilType = "গড়াই ও পদ্মা অববাহিকার উর্বর দোআঁশ মাটি",
            features = "তামাক, ভুট্টা, তিল ও উন্নত জাতের ধান চাষ",
            cropIds = listOf("bhutta", "tamak_o_pan", "gom", "pat", "akher_chash")
        ),
        District(
            id = 41, serialNo = 41, nameBn = "চুয়াডাঙ্গা", nameEn = "Chuadanga", division = "খুলনা",
            soilType = "মাথাভাঙ্গা বিধৌত বেলে দোআঁশ মাটি",
            features = "ভুট্টা, পান, আখ ও উচ্চফলনশীল আম-আম্রপালি",
            cropIds = listOf("bhutta", "tamak_o_pan", "akher_chash", "aam", "morich")
        ),
        District(
            id = 42, serialNo = 42, nameBn = "মেহেরপুর", nameEn = "Meherpur", division = "খুলনা",
            soilType = "উর্বর বেলে দোআঁশ মাটি",
            features = "ভুট্টা, বাঁধাকপি, ফুলকপি ও তরমুজ উৎপাদনে বিখ্যাত",
            cropIds = listOf("bhutta", "shaksobji", "tormuj", "tamak_o_pan")
        ),

        // বরিশাল বিভাগ (৪৩-৪৮)
        District(
            id = 43, serialNo = 43, nameBn = "বরিশাল", nameEn = "Barishal", division = "বরিশাল",
            soilType = "কীর্তনখোলা বিধৌত উর্বর উপকূলীয় পলি মাটি",
            features = "ধান-নদী-খাল, সুস্বাদু পেয়ারা, আমড়া ও বালাম ধান",
            cropIds = listOf("dhan_aman", "dhan_boro", "kola_pepe", "shaksobji")
        ),
        District(
            id = 44, serialNo = 44, nameBn = "পটুয়াখালী", nameEn = "Patuakhali", division = "বরিশাল",
            soilType = "উপকূলীয় পলি ও উপকূলীয় কাদামাটি",
            features = "মুগ ডাল, তরমুজ, সূর্যমুখী ও রোপা আমন ধান",
            cropIds = listOf("tormuj", "masur", "surjomukhi_badam", "dhan_aman")
        ),
        District(
            id = 45, serialNo = 45, nameBn = "ভোলা", nameEn = "Bhola", division = "বরিশাল",
            soilType = "মেঘনার মোহনার অত্যন্ত উর্বর নতুন পলি মাটি",
            features = "মহিষের বাথান, চিনাবাদাম, সুপারি, মরিচ ও তরমুজ",
            cropIds = listOf("surjomukhi_badam", "morich", "tormuj", "dhan_aman")
        ),
        District(
            id = 46, serialNo = 46, nameBn = "পিরোজপুর", nameEn = "Pirojpur", division = "বরিশাল",
            soilType = "নদীবাহিত পলি ও জোয়ারভাটার দোআঁশ মাটি",
            features = "ভাসমান কৃষি, স্বরূপকাঠির পেয়ারা ও নারকেল-সুপারি",
            cropIds = listOf("kola_pepe", "shaksobji", "tamak_o_pan", "dhan_aman")
        ),
        District(
            id = 47, serialNo = 47, nameBn = "বরগুনা", nameEn = "Barguna", division = "বরিশাল",
            soilType = "উপকূলীয় পলি ও মৃদু লবণাক্ত মাটি",
            features = "তরমুজ, সূর্যমুখী, মুগ ডাল ও আমন ধান",
            cropIds = listOf("tormuj", "surjomukhi_badam", "masur", "dhan_aman")
        ),
        District(
            id = 48, serialNo = 48, nameBn = "ঝালকাঠি", nameEn = "Jhalakathi", division = "বরিশাল",
            soilType = "সুগন্ধা ও ধানসিঁড়ি নদী বিধৌত দোআঁশ",
            features = "পেয়ারা, আমড়া, শীতলপাটি বেত ও সুগন্ধি চাল",
            cropIds = listOf("kola_pepe", "dhan_aman", "shaksobji", "dhan_boro")
        ),

        // সিলেট বিভাগ (৪৯-৫২)
        District(
            id = 49, serialNo = 49, nameBn = "সিলেট", nameEn = "Sylhet", division = "সিলেট",
            soilType = "পাহাড়ি অম্লীয় লাল মাটি ও সুরমার পলি",
            features = "দুটি পাতা একটি কুঁড়ির চা, কমলা, সাতকড়া ও বোরো ধান",
            cropIds = listOf("cha", "dhan_boro", "dhan_aman", "kola_pepe")
        ),
        District(
            id = 50, serialNo = 50, nameBn = "মৌলভীবাজার", nameEn = "Moulvibazar", division = "সিলেট",
            soilType = "টিলার অম্লীয় মাটি ও উপত্যকার দোআঁশ মাটি",
            features = "বাংলাদেশের শীর্ষ চা বাগান, রাবার, আনারস ও লেবু",
            cropIds = listOf("cha", "kola_pepe", "dhan_boro", "shaksobji")
        ),
        District(
            id = 51, serialNo = 51, nameBn = "হবিগঞ্জ", nameEn = "Habiganj", division = "সিলেট",
            soilType = "হাওরের পলি কাদা ও টিলার মাটি",
            features = "বিশাল হাওরের বোরো ধান, চা বাগান ও তরমুজ",
            cropIds = listOf("dhan_boro", "cha", "tormuj", "dhan_aman")
        ),
        District(
            id = 52, serialNo = 52, nameBn = "সুনামগঞ্জ", nameEn = "Sunamganj", division = "সিলেট",
            soilType = "টাঙ্গুয়ার হাওর ও সুরমা অববাহিকার গভীর পলি কাদা",
            features = "বাংলাদেশের বৃহত্তম হাওর বেষ্টিত বোরো ধানের মূল ভাণ্ডার",
            cropIds = listOf("dhan_boro", "dhan_aman", "sorisha", "masur")
        ),

        // রংপুর বিভাগ (৫৩-৬০)
        District(
            id = 53, serialNo = 53, nameBn = "রংপুর", nameEn = "Rangpur", division = "রংপুর",
            soilType = "তিস্তা বিধৌত উর্বর বেলে দোআঁশ মাটি",
            features = "হাঁড়িভাঙ্গা আম, গোল আলু, তামাক ও শীতকালীন সবজি",
            cropIds = listOf("aam", "alu", "tamak_o_pan", "bhutta", "shaksobji")
        ),
        District(
            id = 54, serialNo = 54, nameBn = "দিনাজপুর", nameEn = "Dinajpur", division = "রংপুর",
            soilType = "উর্বর বেলে দোআঁশ ও পুরনো পলি মাটি",
            features = "মাদ্রাজ ও বেদানা লিচু, কাটারিভোগ সুগন্ধি চাল ও ভুট্টা",
            cropIds = listOf("lichu", "bhutta", "dhan_aman", "alu", "gom")
        ),
        District(
            id = 55, serialNo = 55, nameBn = "গাইবান্ধা", nameEn = "Gaibandha", division = "রংপুর",
            soilType = "ব্রহ্মপুত্র ও তিস্তার পলি চর মাটি",
            features = "মরিচ, ভুট্টা, চরের মিষ্টি কুমড়া ও বাদাম",
            cropIds = listOf("morich", "bhutta", "surjomukhi_badam", "dhan_boro")
        ),
        District(
            id = 56, serialNo = 56, nameBn = "কুড়িগ্রাম", nameEn = "Kurigram", division = "রংপুর",
            soilType = "ধরলা ও দুধকুমার বিধৌত বালু মিশ্রিত পলি",
            features = "ভুট্টা, পাট, চরাঞ্চলের বাদাম ও বোরো ধান",
            cropIds = listOf("bhutta", "pat", "surjomukhi_badam", "dhan_boro")
        ),
        District(
            id = 57, serialNo = 57, nameBn = "নীলফামারী", nameEn = "Nilphamari", division = "রংপুর",
            soilType = "তিস্তা সেচ ক্যানেলের উর্বর দোআঁশ মাটি",
            features = "উন্নত জাতের আগাম আলু, আদা, ভুট্টা ও ধান",
            cropIds = listOf("alu", "bhutta", "dhan_boro", "morich")
        ),
        District(
            id = 58, serialNo = 58, nameBn = "পঞ্চগড়", nameEn = "Panchagarh", division = "রংপুর",
            soilType = "হিমালয় পাদদেশীয় অম্লীয় নুড়িময় দোআঁশ মাটি",
            features = "সমতল ভূমির অর্গানিক চা, তরমুজ, কমলা ও আলু",
            cropIds = listOf("cha", "tormuj", "alu", "bhutta", "surjomukhi_badam")
        ),
        District(
            id = 59, serialNo = 59, nameBn = "লালমনিরহাট", nameEn = "Lalmonirhat", division = "রংপুর",
            soilType = "তিস্তা অববাহিকার বেলে দোআঁশ মাটি",
            features = "ভুট্টা, তামাক, চরের বাদাম ও শীতের সবজি",
            cropIds = listOf("bhutta", "tamak_o_pan", "surjomukhi_badam", "alu")
        ),
        District(
            id = 60, serialNo = 60, nameBn = "ঠাকুরগাঁও", nameEn = "Thakurgaon", division = "রংপুর",
            soilType = "উর্বর দোআঁশ ও বেলে দোআঁশ মাটি",
            features = "উচ্চফলনশীল গম, ভুট্টা, আখ ও আলুর সমৃদ্ধ জেলা",
            cropIds = listOf("gom", "bhutta", "alu", "akher_chash", "lichu")
        ),

        // ময়মনসিংহ বিভাগ (৬১-৬৪)
        District(
            id = 61, serialNo = 61, nameBn = "ময়মনসিংহ", nameEn = "Mymensingh", division = "ময়মনসিংহ",
            soilType = "পুরাতন ব্রহ্মপুত্র বিধৌত উর্বর দোআঁশ মাটি",
            features = "কৃষি বিশ্ববিদ্যালয় কেন্দ্র, ধান, বেগুন, সরিষা ও মৎস্য চাষ",
            cropIds = listOf("dhan_boro", "dhan_aman", "shaksobji", "sorisha", "pat")
        ),
        District(
            id = 62, serialNo = 62, nameBn = "জামালপুর", nameEn = "Jamalpur", division = "ময়মনসিংহ",
            soilType = "যমুনা ও ব্রহ্মপুত্র চরাঞ্চলের পলি মাটি",
            features = "পাট, লাল মরিচ, সরিষা, ভুট্টা ও বেগুন চাষ",
            cropIds = listOf("morich", "pat", "sorisha", "bhutta", "shaksobji")
        ),
        District(
            id = 63, serialNo = 63, nameBn = "শেরপুর", nameEn = "Sherpur", division = "ময়মনসিংহ",
            soilType = "গারো পাহাড় পাদদেশীয় লাল দোআঁশ ও পলি মাটি",
            features = "তুলশীমালা সুগন্ধি চাল, সরিষা, সবজি ও আমন ধান",
            cropIds = listOf("dhan_aman", "dhan_boro", "sorisha", "shaksobji")
        ),
        District(
            id = 64, serialNo = 64, nameBn = "নেত্রকোণা", nameEn = "Netrokona", division = "ময়মনসিংহ",
            soilType = "কংশ বিধৌত হাওরাঞ্চলের গভীর পলি কাদা মাটি",
            features = "হাওরে প্রচুর বোরো ধান উৎপাদন ও সুগন্ধি চাল",
            cropIds = listOf("dhan_boro", "dhan_aman", "sorisha", "masur")
        )
    )

    val divisions = listOf("সকল", "ঢাকা", "চট্টগ্রাম", "রাজশাহী", "খুলনা", "বরিশাল", "সিলেট", "রংপুর", "ময়মনসিংহ")
}
