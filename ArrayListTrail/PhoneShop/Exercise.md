**Bài tập: Quản lý cửa hàng điện thoại**

Viết chương trình quản lý danh sách điện thoại sử dụng `ArrayList<Phone>`. Mỗi điện thoại gồm các thông tin: mã điện thoại (`id`), tên điện thoại (`name`), hãng sản xuất (`brand`), giá bán (`price`) và số lượng tồn kho (`quantity`). Chương trình có menu gồm các chức năng: thêm điện thoại, hiển thị danh sách điện thoại, tìm kiếm điện thoại theo mã hoặc tên, cập nhật thông tin điện thoại, xóa điện thoại, sắp xếp danh sách theo giá bán tăng dần hoặc giảm dần, sắp xếp theo số lượng tồn kho giảm dần, hiển thị điện thoại có giá cao nhất và thấp nhất, tính tổng giá trị tồn kho của cửa hàng (tổng giá trị = giá bán × số lượng tồn kho của tất cả điện thoại), hiển thị tất cả điện thoại của một hãng sản xuất và thoát chương trình.

Khi thêm điện thoại, chương trình cần kiểm tra dữ liệu nhập vào: mã điện thoại không được để trống và không được trùng; tên điện thoại và hãng sản xuất không được để trống; giá bán phải là số lớn hơn 0; số lượng tồn kho phải là số nguyên không âm. Chức năng cập nhật không cho phép thay đổi mã điện thoại và mọi dữ liệu sau khi cập nhật vẫn phải hợp lệ. Chức năng tìm kiếm và lọc theo hãng không phân biệt chữ hoa và chữ thường. Chức năng sắp xếp sử dụng `Collections.sort()` kết hợp với `Comparator`. Chương trình phải xử lý các trường hợp nhập sai dữ liệu bằng `try-catch` để không bị dừng do ngoại lệ.

**Độ khó: 8.5/10**

**Kiến thức cần sử dụng:**

* OOP (Class, Object)
* `ArrayList`
* Validation
* `try-catch`
* CRUD (Create, Read, Update, Delete)
* `Collections.sort()`
* `Comparator`
* Tìm kiếm và lọc dữ liệu
* Thống kê (max, min, tổng giá trị tồn kho)
* Tìm kiếm không phân biệt chữ hoa và chữ thường
