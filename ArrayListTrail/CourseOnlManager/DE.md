**Bài tập: Quản lý khóa học trực tuyến**

Viết chương trình quản lý danh sách khóa học trực tuyến sử dụng `ArrayList<Course>`. Mỗi khóa học gồm các thông tin: mã khóa học (`id`), tên khóa học (`name`), tên giảng viên (`instructor`), học phí (`price`) và số lượng học viên đã đăng ký (`enrolledStudents`). Chương trình có menu gồm các chức năng: thêm khóa học, hiển thị danh sách khóa học, tìm kiếm khóa học theo mã hoặc tên, cập nhật thông tin khóa học, xóa khóa học, sắp xếp danh sách theo học phí tăng dần hoặc giảm dần, sắp xếp theo số lượng học viên giảm dần, hiển thị khóa học có học phí cao nhất và thấp nhất, hiển thị khóa học có số lượng học viên nhiều nhất, tính tổng doanh thu của tất cả khóa học (doanh thu = học phí × số lượng học viên) và thoát chương trình.

Khi thêm khóa học, chương trình cần kiểm tra dữ liệu nhập vào: mã khóa học không được để trống và không được trùng; tên khóa học và tên giảng viên không được để trống; học phí phải là số lớn hơn 0; số lượng học viên phải là số nguyên không âm. Chức năng cập nhật không cho phép thay đổi mã khóa học và mọi dữ liệu sau khi cập nhật vẫn phải hợp lệ. Chức năng tìm kiếm không phân biệt chữ hoa và chữ thường. Chức năng sắp xếp sử dụng `Collections.sort()` kết hợp với `Comparator`. Chương trình phải xử lý các trường hợp nhập sai dữ liệu bằng `try-catch` để không bị dừng do ngoại lệ.

**Độ khó: 8/10**

**Kiến thức cần sử dụng:**

* OOP (Class, Object)
* `ArrayList`
* Validation
* `try-catch`
* CRUD (Create, Read, Update, Delete)
* `Collections.sort()`
* `Comparator`
* Thống kê dữ liệu (max, min, tổng doanh thu)
* Tìm kiếm không phân biệt chữ hoa và chữ thường
