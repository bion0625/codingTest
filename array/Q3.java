package array;

public class Q3 {
    public static void main(String[] args) {
        String[][] places = {
                {"POOOP","OXXOX","OPXPX","OOXOX","POXXP"},
                {"POOPX","OXPXP","PXXXO","OXXXO","OOOPP"},
                {"PXOPX","OXOXP","OXPOX","OXXOP","PXPOX"},
                {"OOOXX","XOOOX","OOOXX","OXOOX","OOOOO"},
                {"PXPXP","XPXPX","PXPXP","XPXPX","PXPXP"}
        };

        Q3 q3 = new Q3();
        int[] result = q3.solution(places);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i == result.length - 1 ? "" : ","));
        }
    }

    public int[] solution(String[][] places) {
        int[] answers = new int[places.length];
        for (int i = 0; i < places.length; i++) {
            String[] place = places[i];
            char[][] room = new char[place.length][];
            for (int j = 0; j < places[i].length; j++) {
                room[j] = place[j].toCharArray();
            }
            // 거리두기 검사 후 answer에 기록
            answers[i] = isDistanced(room) ? 1 : 0;
        }
        return answers;
    }

    private boolean isDistanced(char[][] room) {
        for (int y = 0; y < room.length; y++) {
            for (int x = 0; x < room[y].length; x++) {
                if (room[y][x] != 'P') continue;
                if (!isDistanced(room, x, y)) return false;
            }
        }
        return true;
    }

    private final int dx[] = {0, -1, 1, 0};
    private final int dy[] = {1, 0, 0, -1};

    private boolean isDistanced(char[][] room, int x, int y) {
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (ny < 0 || ny >= room.length || nx < 0 || nx >= room[y].length) continue;
            switch (room[ny][nx]) {
                case 'P': return false;
                case 'O':
                    if (isNextToVolunteer(room, nx, ny, 3-d)) return false;
                    break;
            }
        }
        return true;
    }

    private boolean isNextToVolunteer(char[][] room, int x, int y, int exclude) {
        for (int d = 0; d < 4; d++) {
            if (d == exclude) continue;

            int nx = x + dx[d];
            int ny = y + dy[d];
            if (ny < 0 || ny >= room.length || nx < 0 || nx >= room[y].length) continue;
            if (room[ny][nx] == 'P') return true;
        }
        return false;
    }
}
