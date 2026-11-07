# Lộ trình học Java Spring Backend

## Mục tiêu

- Mục tiêu nghề nghiệp: ứng tuyển thực tập Java Backend.
- Thời lượng dự kiến: khoảng 2 giờ mỗi ngày, tăng thời gian vào cuối tuần khi có thể.
- Cách học: học khái niệm ngắn, tự viết code, nhận review, sửa và áp dụng vào dự án.

## Lộ trình

- [ ] Java Core: đã hoàn thành Buổi 1–8; tạm gác phần còn lại theo yêu cầu học viên và bổ sung khi cần trong dự án.
- [ ] Giai đoạn hiện tại: Git, Maven, SQL, HTTP và REST API.
- [ ] Spring Core, Spring Boot, REST API, JPA/Hibernate.
- [ ] Spring Security, transaction và testing.
- [ ] Docker, CI/CD cơ bản và deploy.
- [ ] Hoàn thiện dự án portfolio để ứng tuyển thực tập.

## Đánh giá hiện tại — sau Buổi 5

- Tiến độ: hoàn thành tốt phần Java Console nền tảng; đã tự xây dựng và mở rộng ứng dụng quản lý sinh viên.
- Điểm mạnh: class/object, đóng gói, `List`/`ArrayList`, luồng điều khiển, validation đầu vào, `NumberFormatException`, tách hàm nhập liệu, sắp xếp, cập nhật/xóa phần tử và `equals()`/`hashCode()`.
- Cần học tiếp: `Set`/`Map`, interface và kế thừa, generics, enum, Java time/`BigDecimal`, Maven, Git, SQL, HTTP và REST API.
- Mốc Spring dự kiến: sau khoảng 7–10 buổi học trọng tâm nữa; bắt đầu Spring Boot khi đã nắm Maven, SQL cơ bản và HTTP/REST.

## Nhật ký buổi học

### Buổi 1 — Quản lý sinh viên bằng Java Console

- Trạng thái: Hoàn thành.
- Nội dung: class/object, đóng gói, `ArrayList`, vòng lặp, `switch`, tìm kiếm, sắp xếp với `Comparator`, xử lý lỗi nhập liệu.
- Bài làm: `lesson-01/src/Student.java` và `lesson-01/src/StudentManager.java`.
- Đã xác nhận: sắp xếp giảm dần, in lại danh sách và thoát chương trình hoạt động đúng.
- Điểm cần sửa: menu phải hiển thị `0. Thoát`, khớp với lựa chọn thực tế.

### Buổi 2 — ArrayList và tham chiếu object

- Trạng thái: Hoàn thành.
- Nội dung: biến tham chiếu object, tìm object trong `ArrayList` và cập nhật trực tiếp bằng setter.
- Bài làm: thêm lựa chọn `7. Cập nhật điểm sinh viên` và phương thức `updateScore()`.
- Đã xác nhận: cập nhật ID 101 từ 8.5 lên 9.5; tìm lại ID trả về điểm mới; ID 999 báo không tìm thấy; điểm 12 bị từ chối và chỉ chấp nhận điểm hợp lệ.
- Cải thiện đã áp dụng: chỉ gọi `getStudentById(id)` một lần để lấy `Student` cần cập nhật.

### Buổi 3 — Exception và tái sử dụng code

- Trạng thái: Hoàn thành.
- Nội dung: `NumberFormatException`, vòng lặp yêu cầu nhập lại và tách logic nhập liệu thành các hàm tái sử dụng.
- Bài làm: `readInt(String prompt)` và `readScore(String prompt)`; các chức năng menu, thêm, tìm và cập nhật đã gọi lại các hàm này.
- Đã xác nhận: nhập chữ ở vị trí cần số nguyên; nhập chuỗi sai định dạng và điểm ngoài 0–10; chương trình báo lỗi, in lại lời nhắc và tiếp tục chạy.

### Buổi 4 — List interface và thao tác với danh sách

- Trạng thái: Hoàn thành.
- Nội dung: khai báo theo interface `List`, triển khai bằng `ArrayList`, ý nghĩa của `final` với biến tham chiếu và xóa object khỏi danh sách.
- Bài làm: đổi khai báo sang `private static final List<Student> studentList = new ArrayList<>();`; thêm lựa chọn xóa sinh viên theo ID.
- Đã xác nhận: xóa ID 101; tìm lại ID báo không thấy; danh sách còn ba sinh viên; ID 999 được xử lý không lỗi; lựa chọn `0` thoát chương trình.
- Điểm cần nhớ: `remove(student)` dùng `remove(Object)`; hiện tại nó xóa được vì `getStudentById` trả về đúng object nằm trong danh sách.

### Buổi 5 — `equals()` và `hashCode()`

- Trạng thái: Hoàn thành.
- Nội dung: object identity với `==`, logical equality với `equals()`, và quy tắc kết hợp giữa `equals()` với `hashCode()`.
- Bài làm: override `equals()` và `hashCode()` trong `Student`, coi hai sinh viên có cùng ID là giống nhau; tạo `StudentEqualityDemo.java`.
- Đã xác nhận: hai object khác nhau cùng ID có `==` là `false`, `equals()` là `true`, hash code cùng là `101`; object ID 102 không bằng object ID 101.
- Điểm cần nhớ: `ArrayList` vẫn cho thêm phần tử trùng vì `add()` không loại trùng; `HashSet` sẽ dùng `equals()` và `hashCode()` để làm việc này.

### Buổi 6 — `Set` và `HashSet`

- Trạng thái: Hoàn thành.
- Mục tiêu: dùng `HashSet` để lưu dữ liệu không trùng lặp và thấy rõ vai trò thực tế của `equals()` với `hashCode()`.
- Bài làm: dùng `Set<Student>` triển khai bằng `HashSet`, thêm hai object ID 101 và một object ID 102.
- Đã xác nhận: kết quả `add()` là `true`, `false`, `true`; kích thước Set là `2`; `contains()` với một object mới ID 101 trả về `true`.

### Buổi 7 — `Map` và `HashMap`

- Trạng thái: Hoàn thành.
- Mục tiêu: lưu và tìm dữ liệu bằng khóa; dùng ID sinh viên làm key để thay thế tìm kiếm tuần tự trong danh sách.
- Bài làm: `StudentMapDemo.java` với `Map<Integer, Student>` triển khai bằng `HashMap`.
- Đã xác nhận: thêm ID 101 và 102; chặn ID 101 trùng; tìm và cập nhật điểm ID 101; xóa ID 102; tìm ID 102 báo không thấy.
- Điểm cần nhớ: `get(id)` trả về `null` khi không có key; ở code hiện tại có thể dùng giá trị này thay cho `containsKey(id)` rồi `get(id)` để tránh tra Map hai lần.

### Buổi 8 — Interface và đa hình

- Trạng thái: Hoàn thành.
- Mục tiêu: định nghĩa một hợp đồng bằng interface và để nhiều class triển khai cùng một hành vi theo các cách khác nhau.
- Bài làm: `StudentRepository`, `InMemoryStudentRepository` và `StudentMapDemo`; repository lưu dữ liệu bằng Map, demo gọi qua interface và in thông báo.
- Đã xác nhận: biên dịch thành công; chặn ID trùng; cập nhật điểm ID 101 thành 9.5; xóa ID 102; số sinh viên còn lại là 1; tìm ID đã xóa trả về không thấy.
- Hiểu bài: học viên giải thích đúng lời gọi qua `StudentRepository` thực thi phương thức của object `InMemoryStudentRepository`; đã tái sử dụng kết quả `findById()` thay vì gọi hai lần.

### Buổi 9 — Enum, LocalDate và BigDecimal

- Trạng thái: Tạm gác theo yêu cầu học viên; chưa xác nhận hoàn thành.
- Mục tiêu: biểu diễn trạng thái bằng enum, ngày nhập học bằng LocalDate và học phí bằng BigDecimal.
- Bài tập: mở rộng Student bằng getter/setter và giá trị mặc định; tạo StudentDetailsDemo để kiểm tra trạng thái, ngày và phép tính học phí.

## Những điểm cần ôn lại

Điều chỉnh lộ trình ngày 2026-11-06: chuyển sang Git → Maven → SQL → HTTP/REST → Spring Boot. Java Core còn thiếu được bổ sung trong thực hành. Giữ đánh giá sau mỗi 5 buổi hoàn thành; buổi tạm gác không tính là hoàn thành.

- `break` chỉ thoát khỏi `switch`; `return` kết thúc hàm `main`.
- Hai biến object có thể cùng tham chiếu đến một object trong bộ nhớ.

## Quy ước cập nhật

Sau mỗi buổi, ghi lại: nội dung đã học, trạng thái bài tập, lỗi hoặc điểm yếu cần ôn, và bài tiếp theo.

Sau mỗi 5 buổi hoàn thành, thực hiện một lần đánh giá: xem lại kiến thức, làm một bài tổng hợp ngắn, đánh giá điểm mạnh/điểm cần cải thiện và điều chỉnh lộ trình nếu cần. Các mốc dự kiến: Buổi 5, 10, 15, 20, ...
