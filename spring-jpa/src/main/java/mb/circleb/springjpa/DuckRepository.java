package mb.circleb.springjpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DuckRepository extends JpaRepository<Duck, Long> {
}
