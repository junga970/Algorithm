import java.util.*;

class Music {
    int id;
    int play;
    
    public Music(int id, int play) {
        this.id = id;
        this.play = play;
    }
}

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        // 장르별 플레이 횟수 정렬 필요
        HashMap<String, Long> map = new HashMap<>();
        HashMap<String, ArrayList<Music>> musicMap = new HashMap<>();
        
        for(int i = 0; i < genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0L) + plays[i]);
            
            if (!musicMap.containsKey(genres[i])) {
                musicMap.put(genres[i], new ArrayList<>());
            }

            musicMap.get(genres[i]).add(new Music(i, plays[i]));
        }
            
        // 장르내 플레이 횟수 정렬 필요
        List<Map.Entry<String, Long>> genreList = new ArrayList<>(map.entrySet());

        genreList.sort(
            Map.Entry.<String, Long>comparingByValue().reversed()
        );
        
        List<Integer> answer = new ArrayList<>();

        for (Map.Entry<String, Long> genre : genreList) {

            List<Music> musics = musicMap.get(genre.getKey());

            musics.sort(
                Comparator.comparingInt((Music m) -> m.play).reversed()
                          .thenComparingInt(m -> m.id)
            );

            // 최대 2곡 추가
            for (int i = 0; i < Math.min(2, musics.size()); i++) {
                answer.add(musics.get(i).id);
            }
        }

        // List<Integer> -> int[]
        return answer.stream()
                     .mapToInt(Integer::intValue)
                     .toArray();
    }
}

