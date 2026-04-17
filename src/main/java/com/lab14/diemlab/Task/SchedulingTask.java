package com.lab14.diemlab.Task;

import com.lab14.diemlab.Service.HocSinhService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//Khai báo cho hệ thống là hãy quản lí class này giúp tôi
@Component
// Tiêm hàm khởi tạo vào class với chỉ 1 lần duy nhất (final)
@RequiredArgsConstructor
// Tự động tạo biến log để in ra màn hình
@Slf4j
public class SchedulingTask {
    // format thời gian  chuẩn Năm(yyyy)-Tháng(MM)-Ngày(dd) Giờ(HH)-Phút(mm)-Giây(ss)
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    // Tiêm hàm khởi tạo
    private final HocSinhService hocSinhService;

    //Đặt Lịch
    // */10- cứ sau 10 giây chạy 1 lần bắt đầu từ 0 giây
    // *-Phút
    // *-Giờ
    // *-Ngày
    // *-Tháng
    // ?-Ngày Trong tuần
    @Scheduled(cron = "${app.task.cron}")
    public void scheduledTaskWithCronExpression() {
        log.info("Cron Task  : Time-{}", LocalDateTime.now().format(formatter));
        log.info("Student in DB - {}",hocSinhService.count());
    }
}
