# MVP Sample

## Khái niệm

* MVP (Model, View, Presenter) là mẫu cho phép tác các lớp trình bày ra khỏi lớp logic, đó là mọi thứ về cách làm thế nào mà giao diện được tách biệt với cách mà chúng ta sẽ cho nó hiển thị lên màn hình thế nào. Lý tưởng nhất là mẫu MVP sẽ đạt được cùng logic có thể khác nhau hoặc là hoán đổi cho nhau.

* Đầu tiên phải làm rõ MVP không phải là một mẫu thiết kế, nó chỉ chịu trách nhiệm cho phân lớp trình bày mà thôi. Trong mọi trường hợp thì nó luôn luôn tốt hơn khi sử dụng cho kiến trúc ứng dụng của bạn hơn là không dùng. 

![](https://qph.fs.quoracdn.net/main-qimg-621a3043c895a48460e9e802536cbd4b) 

## Mục tiêu

* Tách mã cho các chế độ xem trên màn hình như là danh sách, nút bấm, nhãn, box, văn bản, ... từ các logic nghiệp vụ riêng được kích hoạt trên tương tác của người dùng với chế độ xem mà nó được gọi là người trình bày (presenter). Dữ liệu mà được hiển thị trong chế độ xem phải được cung cấp bởi 1 module riêng biệt khác mà nó được gọi là model. Trong mã nguồn trở lên dễ đọc, dễ hiểu và dễ bảo trì.

* Giao tiếp giữa các chế độ view và model cần diễn ra thông qua presenter, chẳng hạn view và model không thể có tham chiếu của nhau. 

*Sử dụng mẫu thiết kế này, chúng ta có thể thay đổi một số thành phần mà không cần thay đổi bất kì mã nào của 2 thành phần còn lại. Cũng trong trường hợp chúng ta muốn thay thế hoàn toàn view hoặc model bằng một triển khai khác, cũng nên có khả năng đó. Ví dụ bạn có thể sử dụng nhà cung cấp nội dung để có được danh sách các video, mà ngày mai nên được thay thế bằng cơ sở dữ liệu sqLite mà không thay đổi trong bất kỳ phần khác.

* Tối ưu code của bạn để có thể viết test tự động cho nó

## Android Activity và MVP

* Android framework làm cho nó thực sự dễ dàng hơn để bắt đầu bất kì 1 ý tưởng mà bạn có trong tâm trí, nhưng cấu trúc mã này sẽ sớm trở thành không thể quản lý bởi các đoạn code, clas, các chức năng khác nhau trong ứng dụng, và tất cả chúng tập hợp lại vào 1 activity hoặc fragment

* Bây giờ, activity của android dường như cung cấp các chức năng của view kể từ khi chúng ta làm 1 số việc như setContentView() trong hàm onCreate(). Activity đồng thời duy trì các sự kiện trong vòng đời của nó như onCreate(), onResume(), ... đó là logic tức là presenter.

* Ví dụ:

    * Đăng kí lắng nghe sự tương tác của người dùng đối với giao diện của người dùng thuộc dạng View

    * Thực hiện các hành động để phản hồi lại tương tác của người dùng với giao diện của ứng  dung. Hầu hết mọi người sẽ debug 1 họat động với 1 số dòng mã đã đăng kí giao diện. người dùng và đồng thời cũng có một vào dòng code được nhúng vào đây và có lỗi xảy ra ở đây thì rất khó chịu.

* Bây giờ, trên cơ sở Nguyên tắc chịu trách nhiệm duy nhất, chúng ta cần phải chỉ định cho Activity những nguyên tắc của view hoặc presenter. Tôi quyết định sử dụng Activity với tư cách là Presentẻ, bởi vì Activity có ngữ cảnh cụ thể (là đối tượng thần cung cấp quyền truy cập vào hầu hết các tính năng của nền tảng). Điều này làm cho Activity là sự lựa chọn tự nhiên để giữ trách nhiệm cho logic nghiệp vụ. Sau khi tất cả chúng tôi muốn giữ cho view chỉ có các chức năng để tải các yếu tố giao diện người dùng.

## Tại sao sử dụng MVP?

* Chúng tôi chia ứng dụng ra thành ít nhất 3 phân lớp khác nhau, điều này cho phép chúng tôi kiểm tra chúng độc lập với nhau

* Sử dụng mô hình MVP dễ mở rộng và duy trì

* Sử dụng MVP, chúng tôi có thể viết được những unit-test dễ dàng, với MVP chúng tôi có thể tận dụng tối đa được logic từ các hoạt động để chúng ta có thể kiểm tra nó 

* Sử dụng MVP, chúng ta có thể sử dụng TDD (Test Driven Development)

## Model

* Nó đủ để xem nó như nhà cung cấp dữ liệu chúng tôi muốn hiển thị trong view

* Có những phương pháp phục hồi dữ liệu 

* Chuyển hướng tới xử lý logic

## View

* Được hiểu là các thành phần như: Activity, Fragment, View, ..

* Có tham chiếu đến Presenter

* Chuyển các sự kiện từ giao diện của người dùng đến Presenter (onClick, vòng đời của các sự kiện)

* Kiểm soát việc trình bày dữ liệu 

* Thực hiện với các layout (show/hide layout, show notification)

## Present

* Là người đứng giữa Model và View

* Chứa logic của view để chuẩn bị nội dung để hiển thị (như nhận từ Models) và phản ứng với thao tác của người dùng (bằng cách yêu cầu dữ liệu từ View).

* Giới thiệu mức độ trừu tượng đối với dữ liệu từ Models và định dạng nó trước khi gửi tới View.  

* Điều này cho phép Models và View hoạt động độc lập nhau

* Cập nhật UI - sự khác biệt với MVC.