package com.alljedi.bottomnavigationapplication.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//TODO: get data
public class JournalContent {

        public static final List<StarItem> ITEMS = new ArrayList<StarItem>();

        public static final Map<String, StarItem> ITEM_MAP = new HashMap<String, StarItem>();

        private static final int COUNT = 25;

        static {
            for (int i = 1; i <= COUNT; i++) {
                addItem(createJournalItem(i));
            }
        }

        private static void addItem(StarItem item) {
            ITEMS.add(item);
            ITEM_MAP.put(item.id, item);
        }

        private static StarItem createJournalItem(int position) {
            return new StarItem(String.valueOf(position), "Item " + position, makeDetails(position));
        }

        private static String makeDetails(int position) {
            StringBuilder builder = new StringBuilder();
            builder.append("Details about Item: ").append(position);
            for (int i = 0; i < position; i++) {
                builder.append("\nMore details information here.");
            }
            return builder.toString();
        }

        /**
         * A journal item representing a piece of content.
         */
        public static class JournalItem {
            public final String id;
            public final String content;
            public final String details;

            public JournalItem(String id, String content, String details) {
                this.id = id;
                this.content = content;
                this.details = details;
            }

            @Override
            public String toString() {
                return content;
            }
        }

}
