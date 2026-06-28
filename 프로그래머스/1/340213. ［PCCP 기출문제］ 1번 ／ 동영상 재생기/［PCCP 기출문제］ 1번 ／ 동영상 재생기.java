class Solution {
    private Time start;
    private Time end;
    private Time total;

    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        StringBuilder sb = new StringBuilder();
        Time now = new Time(pos);
        start = new Time(op_start);
        end = new Time(op_end);
        total = new Time(video_len);
        skipOpening(now);
        for(String command : commands){
            switch(command){
                case "next":
                    now.plusSeconds(total);
                    break;
                case "prev":
                    now.minusSeconds();
                    break;
            }
            skipOpening(now);
        }
        return now.toString();
    }

    // 오프닝 구간 검증
    private void skipOpening(Time now){
        if(now.compareTo(start) >= 0 && now.compareTo(end) <= 0){
            now.skip(end);
        }
    }

    public static class Time{
        private Integer minutes;
        private Integer seconds;

        public Time(String pos){
            String[] split = pos.split(":");
            this.minutes = Integer.parseInt(split[0]);
            this.seconds = Integer.parseInt(split[1]);
        }

        public Integer minutes(){
            return this.minutes;
        }

        public Integer seconds(){
            return this.seconds;
        }

        public void skip(Time end){
            this.minutes = end.minutes();
            this.seconds = end.seconds();
        }

        public void plusSeconds(Time total){
            this.seconds += 10;
            if(seconds >= 60){
                this.minutes += 1;
                seconds -= 60;
            }

            if(this.compareTo(total) > 0){
                this.minutes = total.minutes();
                this.seconds = total.seconds();
            }
        }

        public void minusSeconds(){
            this.seconds -= 10;
            if(seconds < 0){
                if(this.minutes > 0){
                    this.minutes -= 1;
                    seconds += 60;    
                }else{
                    this.seconds = 0;
                }

            }
        }

        public int compareTo(Time other){
            if(this.minutes.equals(other.minutes())){
                return this.seconds.compareTo(other.seconds());
            }
            return this.minutes.compareTo(other.minutes());
        }

        @Override
        public String toString(){
            return String.format("%02d:%02d",minutes,seconds);
        }

    }
}