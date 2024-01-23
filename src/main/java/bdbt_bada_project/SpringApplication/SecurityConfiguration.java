package bdbt_bada_project.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user")
                .password("user")
                .roles("USER")
                .and()
                .withUser("admin")
                .password("admin")
                .roles("ADMIN")
                .and()
                .withUser("Pi")
                .password("Pi")
                .roles("USER", "UPi")
                .and()
                .withUser("Korek")
                .password("Korek")
                .roles("USER", "UKorek")
                .and()
                .withUser("Sobotka")
                .password("Sobotka")
                .roles("USER", "USobotka");

    }
    @Bean
    public PasswordEncoder getPasswordEncoder() { return NoOpPasswordEncoder.getInstance();
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/index").permitAll()
                .antMatchers("/resources/static/**").permitAll()
                .antMatchers("/main").authenticated()
                .antMatchers("/main_admin").access("hasRole('ADMIN')")
                .antMatchers("/tabela_hurtownie").access("hasRole('ADMIN')")
                .antMatchers("/tabela_klienci").access("hasRole('ADMIN')")
                .antMatchers("/tabela_produkty").access("hasRole('ADMIN')")

                .antMatchers("/newHurtownie").access("hasRole('ADMIN')")
                .antMatchers("/newProdukty").access("hasRole('ADMIN')")
                .antMatchers("/newKlienci").access("hasRole('ADMIN')")


                .antMatchers("/deleteHurtownie/{nrHurtowni}").access("hasRole('ADMIN')")
                .antMatchers("/deleteProdukty/{nrProduktu}").access("hasRole('ADMIN')")
                .antMatchers("/deleteKlienci/{nrKlienta}").access("hasRole('ADMIN')")

                .antMatchers("/editKlienci/300").access("hasAnyRole('USER', 'ADMIN')")
                .antMatchers("/editKlienci/147").access("hasAnyRole('UPi', 'ADMIN')")
                .antMatchers("/editKlienci/148").access("hasAnyRole('Ukorek', 'ADMIN')")
                .antMatchers("/editKlienci/149").access("hasAnyRole('USobotka', 'ADMIN')")

                .antMatchers("/main_user").access("hasRole('USER')")
                .antMatchers("/moje_dane/Pi").access("hasRole('UPi')")
                .antMatchers("/moje_dane/Korek").access("hasRole('UKorek')")
                .antMatchers("/moje_dane/Sobotka").access("hasRole('USobotka')")
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/main")
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/index")
                .logoutSuccessUrl("/index")
                .permitAll();
    }
}