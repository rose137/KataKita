package com.example.katakita.Repository;

import android.os.Build;
import java.util.Random;
import com.example.katakita.model.ChatItemModel;
import com.example.katakita.model.ChatMessageModel;
import com.example.katakita.model.MessageStatus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChatRepository {
    private static List<ChatItemModel> chatList = new ArrayList<>();
    private static Map<String, List<ChatMessageModel>> messageMap = new HashMap<>();


    static {
        // Data ChatItemModel (user list)
        chatList.add(new ChatItemModel("Andi", "Hai, kamu lagi apa?", "10:20 AM", "https://images.icon-icons.com/1286/PNG/512/4_85233.png", true, 2));
        chatList.add(new ChatItemModel("Budi", "Oke nanti aku kabari ya", "11:45 AM", "https://images.icon-icons.com/4057/PNG/512/pleased_happy_cute_success_superstar_star_super_sticker_icon_258432.png", false, 0));
        chatList.add(new ChatItemModel("Citra", "Thanks ya!", "12:00 PM", "https://images.icon-icons.com/4132/PNG/512/animal_cute_animals_cartoon_tiger_icon_260622.png", true, 1));
        chatList.add(new ChatItemModel("Dewi", "Yuk ngopi", "Yesterday", "https://images.icon-icons.com/4132/PNG/512/cute_animal_chicken_cartoon_icon_260620.png", false, 0));
        chatList.add(new ChatItemModel("Eko", "Sudah di jalan", "09:30 AM", "https://images.icon-icons.com/30/PNG/256/animal_toy_cute_doll_teddy_2742.png", true, 3));
        chatList.add(new ChatItemModel("Fajar", "Aku OTW", "10:15 AM", "https://images.icon-icons.com/1060/PNG/512/PigPorcelaine_Mac_Archigraphs_512x512_icon-icons.com_76783.png", false, 0));
        chatList.add(new ChatItemModel("Gita", "Hihi iya", "11:10 AM", "https://images.icon-icons.com/1286/PNG/512/78_85257.png", true, 5));
        chatList.add(new ChatItemModel("Hari", "Gimana kabar?", "10:55 AM", "https://images.icon-icons.com/1286/PNG/512/41_85235.png", false, 0));
        chatList.add(new ChatItemModel("Dini", "Hai, kamu lagi apa?", "10:20 AM", "https://images.icon-icons.com/1286/PNG/512/4_85233.png", true, 0));
        chatList.add(new ChatItemModel("Susi", "Oke nanti aku kabari ya", "11:45 AM", "https://images.icon-icons.com/4057/PNG/512/pleased_happy_cute_success_superstar_star_super_sticker_icon_258432.png", true, 0));
        chatList.add(new ChatItemModel("Aidil", "Thanks ya!", "12:00 PM", "https://images.icon-icons.com/4132/PNG/512/animal_cute_animals_cartoon_tiger_icon_260622.png", true, 2));
        chatList.add(new ChatItemModel("Khafi", "Yuk ngopi", "Yesterday", "https://images.icon-icons.com/4132/PNG/512/cute_animal_chicken_cartoon_icon_260620.png", false, 1));
        chatList.add(new ChatItemModel("Ekmo", "Sudah di jalan", "09:30 AM", "https://images.icon-icons.com/30/PNG/256/animal_toy_cute_doll_teddy_2742.png", true, 4));
        chatList.add(new ChatItemModel("Dani", "Aku OTW", "10:15 AM", "https://images.icon-icons.com/1060/PNG/512/PigPorcelaine_Mac_Archigraphs_512x512_icon-icons.com_76783.png", true, 0));
        chatList.add(new ChatItemModel("Suri", "Hihi iya", "11:10 AM", "https://images.icon-icons.com/1286/PNG/512/78_85257.png", true, 2));
        chatList.add(new ChatItemModel("Tanjiro", "Gimana kabar?", "10:55 AM", "https://images.icon-icons.com/1286/PNG/512/41_85235.png", false, 0));
        chatList.add(new ChatItemModel("Akame", "Hai, kamu lagi apa?", "10:20 AM", "https://images.icon-icons.com/1286/PNG/512/4_85233.png", true, 0));
        chatList.add(new ChatItemModel("Sutiyono", "Oke nanti aku kabari ya", "11:45 AM", "https://images.icon-icons.com/4057/PNG/512/pleased_happy_cute_success_superstar_star_super_sticker_icon_258432.png", false, 0));
        chatList.add(new ChatItemModel("Halun", "Thanks ya!", "12:00 PM", "https://images.icon-icons.com/4132/PNG/512/animal_cute_animals_cartoon_tiger_icon_260622.png", true, 3));
        chatList.add(new ChatItemModel("Aluna", "Yuk ngopi", "Yesterday", "https://images.icon-icons.com/4132/PNG/512/cute_animal_chicken_cartoon_icon_260620.png", false, 1));
        chatList.add(new ChatItemModel("KoKom", "Sudah di jalan", "09:30 AM", "https://images.icon-icons.com/30/PNG/256/animal_toy_cute_doll_teddy_2742.png", true, 2));
        chatList.add(new ChatItemModel("Gusti", "Aku OTW", "10:15 AM", "https://images.icon-icons.com/1060/PNG/512/PigPorcelaine_Mac_Archigraphs_512x512_icon-icons.com_76783.png", true, 0));
        chatList.add(new ChatItemModel("Saria", "Hihi iya", "11:10 AM", "https://images.icon-icons.com/1286/PNG/512/78_85257.png", true, 1));
        chatList.add(new ChatItemModel("Akmal", "Gimana kabar?", "10:55 AM", "https://images.icon-icons.com/1286/PNG/512/41_85235.png", true, 0));


        String[] dummyUserMessages = {
                "Halo, apa kabar?",
                "Kamu sedang sibuk?",
                "Sudah makan belum?",
                "Besok kita ketemu ya!",
                "Aku ada kabar baik nih",
                "Gimana kerjaannya?",
                "Mau nonton film gak?",
                "Lagi di mana sekarang?",
                "Seru banget tadi acaranya!",
                "Sampai ketemu nanti!",
                // Tambahan percakapan nonton bioskop dan popcorn
                "Udah nonton Kimetsu no Yaiba belum?",
                "Popcorn di bioskop itu enak banget ya!",
                "Eh, trailernya Kimetsu no Yaiba keren banget!",
                "Kapan kita nonton bareng, popcorn-nya aku yang traktir!",
                "Tahu gak, episode terbaru Kimetsu no Yaiba rame banget di medsos!",
                "Aku pengen beli popcorn rasa baru itu, kamu udah coba belum?",
                "Film Kimetsu no Yaiba lagi hits banget sekarang!",
                "Bioskop penuh pas tayang Kimetsu no Yaiba, kamu gimana?",
                "Jangan lupa bawa masker kalau ke bioskop ya!",
                "Suka sama soundtrack-nya Kimetsu no Yaiba gak?"
        };



        String[] dummyMyMessages = {
                "Hai, baik kok!",
                "Aku lagi santai aja.",
                "Sudah makan, makasih.",
                "Oke siap!",
                "Wah, apa itu?",
                "Kerjaannya lancar.",
                "Boleh tuh, kapan?",
                "Sedang di rumah.",
                "Seru banget ya!",
                "Sampai nanti!",
                // Tambahan percakapan nonton bioskop dan popcorn
                "Belum nih, pengen banget nonton Kimetsu no Yaiba!",
                "Iya, popcorn di bioskop juara rasanya!",
                "Trailer-nya bikin penasaran banget!",
                "Asal jangan lupa bawa uang buat popcorn ya!",
                "Iya, aku juga sering lihat di TikTok tentang Kimetsu no Yaiba.",
                "Belum coba yang rasa baru, kamu rekomendasiin dong!",
                "Bener banget, filmnya keren dan penuh aksi!",
                "Wah, bioskop jadi ramai ya! Semoga dapat tempat duduk.",
                "Masker pasti aku bawa kok, safety first!",
                "Soundtrack-nya bikin suasana makin dramatis, aku suka!"
        };

        Random random = new Random();


        // Buat tiap nama chat, generate 50 chat dummy pesan
        for (ChatItemModel chatItem : chatList) {
            List<ChatMessageModel> messages = new ArrayList<>();
            for (int i = 0; i < 50; i++) {
                boolean sentByUser = i % 2 == 0;

                String content;
                if (sentByUser) {
                    content = "Saya: " + dummyMyMessages[i % dummyMyMessages.length];
                } else {
                    content = chatItem.getName() + ": " + dummyUserMessages[i % dummyUserMessages.length];
                }

                MessageStatus status;
                if (sentByUser) {
                    if (i % 3 == 0) {
                        status = MessageStatus.SENT;
                    } else if (i % 3 == 1) {
                        status = MessageStatus.DELIVERED;
                    } else {
                        status = MessageStatus.READ;
                    }
                } else {
                    status = MessageStatus.READ;
                }

                String time = "10:" + String.format("%02d", (i + 1) % 60) + " AM";

                messages.add(new ChatMessageModel(content, time, status,sentByUser));

            }
            messageMap.put(chatItem.getName(), messages);
        }

    }

    // Dapatkan list chat
    public static List<ChatItemModel> getChatData() {
        return chatList;
    }

    public static List<ChatMessageModel> getMessagesByUserName(String userName) {
        List<ChatMessageModel> messages = messageMap.get(userName);
        if (messages == null) {
            return new ArrayList<>();
        }
        return messages;
    }

}
