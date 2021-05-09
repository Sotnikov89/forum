package ru.forum.bootstrap;

import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import ru.forum.domain.Post;
import ru.forum.domain.Role;
import ru.forum.repositories.PostRepository;
import ru.forum.repositories.RoleRepository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Component
@AllArgsConstructor
@Profile("h2")
public class LoadForH2 implements ApplicationListener<ContextRefreshedEvent> {

    private final PostRepository postRepository;
    private final RoleRepository roleRepository;

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        postRepository.saveAll(createPosts());
        roleRepository.save(Role.builder().name("ROLE_USER").build());
    }

    private List<Post> createPosts() {
        return List.of(
                Post.builder().name("Продам Ладу 2109")
                        .desc("Авто на ходу. Простая музыка. Шумка в два слоя по полу. "
                                + "Дно переварено.кулиса не разбита.двери гнилые. Всё видно на фото.едет бодро.торг у капота.")
                        .created(LocalDateTime.now()).build(),

                Post.builder().name("Среднеазиатская овчарка в добрые руки")
                        .desc("Отдадим в добрые руки (через договор)!!! Алабай 6 лет. Добрый и ласковый пёс. "
                                + "Отличный друг в свой дом!!! Коммуникабельный с другими собаками (дружил с небольшой собакой, уже в взрослом возрасте). Не кастрирован, развязан! "
                                + "Не травили и не обижали!!! Отдаём т.к. хозяин умер и к сожалению держать его в квартире не можем!!!")
                        .created(LocalDateTime.now()).build(),
                Post.builder().name("Россиянка Тамара Тансыккужина выиграла чемпионат мира по шашкам")
                        .desc("Финальный из девяти раундов проходил в Варшаве, 42-летняя Тансыккужина переиграла 29-летнюю "
                                + "польку Наталью Садовскую. Победитель определился на тай-брейке. После девяти раундов противостояния "
                                + "счет был равным: 54:54. Далее вничью завершились две партии в быстрые шашки и три партии в блиц, в четвертой партии в блиц Тансыккужина одержала победу.")
                        .created(LocalDateTime.now()).build()
        );
    }
}
